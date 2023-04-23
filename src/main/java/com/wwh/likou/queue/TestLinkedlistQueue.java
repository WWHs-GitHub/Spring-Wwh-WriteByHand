package com.wwh.likou.queue;

import java.util.Iterator;

public class TestLinkedlistQueue {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

//        System.out.println(queue.isEmpty());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println(queue.offer(6));

    }
}
