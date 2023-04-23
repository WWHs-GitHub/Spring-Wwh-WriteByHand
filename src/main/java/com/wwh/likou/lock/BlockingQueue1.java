package com.wwh.likou.lock;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class BlockingQueue1<E> implements BlockingQueue<E>{

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()){
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail >= array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException { // 毫秒
        lock.lockInterruptibly();
        long t = TimeUnit.MILLISECONDS.toNanos(timeout);
        try {
            while (isFull()){
                if (t < 0){
                    return false;
                }
                t = tailWaits.awaitNanos(t);
            }
            array[tail] = e;
            if (++tail >= array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()){
                headWaits.await();
            }
            E value = array[head];
            if (++head >= array.length){
                head = 0;
            }
            size--;
            tailWaits.signal();
            return value;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
