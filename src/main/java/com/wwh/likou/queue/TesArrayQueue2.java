package com.wwh.likou.queue;

import java.util.Iterator;

public class TesArrayQueue2 {

    public static void main(String[] args) {
        ArrayQueue02<Integer> queue = new ArrayQueue02<>(5);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
