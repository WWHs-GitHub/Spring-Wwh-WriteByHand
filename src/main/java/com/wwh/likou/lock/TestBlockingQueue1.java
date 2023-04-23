package com.wwh.likou.lock;

import java.util.concurrent.TimeUnit;

public class TestBlockingQueue1 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " begin");
                queue.offer("任务一");
                System.out.println(queue);
                queue.offer("任务二");
                System.out.println(queue);
                queue.offer("任务三");
                System.out.println(queue);
                queue.offer("任务四", 5000);
                System.out.println(queue);
                System.out.println(System.currentTimeMillis() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者");
        t1.start();

//        TimeUnit.SECONDS.sleep(2);
        queue.poll();
        System.out.println("取出元素");
    }
}
