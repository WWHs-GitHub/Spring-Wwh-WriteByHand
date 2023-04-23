package com.wwh.likou.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void offer(String e) throws InterruptedException {
        lock.lockInterruptibly(); // 加锁(可以在阻塞状态随时打断)
        try {
            while (isFull()){
                // 满了该做的事
                condition.await();
            }
            array[tail] = e;
            if (++tail >= array.length){
                tail = 0;
            }
            size++;
        }finally {
            lock.unlock();
        }
    }

    public boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadUnsafe threadUnsafe = new TestThreadUnsafe();
        for (int i = 0; i < 10; i++) {
            threadUnsafe.offer(i + " ");
        }

        new Thread(() -> {
            System.out.println("开始执行添加之前...");
            try {
                threadUnsafe.offer("10");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始执行添加之后...");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            System.out.println("开始唤醒...");
            try {
                threadUnsafe.lock.lockInterruptibly();
                threadUnsafe.condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                threadUnsafe.lock.unlock();
            }
        }).start();
    }
}
