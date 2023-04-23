package com.wwh.likou.lock;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class BlockingQueue2<E> implements BlockingQueue<E>{

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger(0);

    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private boolean isEmpty(){
        return size.get() == 0;
    }

    private boolean isFull(){
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        int c = 0;
        try {
            while (isFull()){
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail >= array.length){
                tail = 0;
            }
            c = size.getAndIncrement();

            if (c + 1 < array.length){
                tailWaits.signal();
            }

        }finally {
            tailLock.unlock();
        }

        // 如果从0变为非空，由offer这边唤醒等待非空的 poll 线程
        if (c == 0){
            headLock.lock();
            try {
                headWaits.signal();
            }finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        headLock.lockInterruptibly();
        E value = null;
        int c = 0;
        try {
            while (isFull()) {
                headWaits.await();
            }
            value = array[head];
            if (++head >= array.length) {
                head = 0;
            }
            c = size.getAndDecrement();

            if (c > 1){
                headWaits.signal();
            }

        } finally {
            headLock.unlock();
        }

        // 队列从满 -> 不满时，由poll唤醒等待不满的 offer 线程
        if (c == array.length){
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
