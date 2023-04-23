package com.wwh.likou.queue;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TesArrayQueue3 {

    public static void main(String[] args) {
        ArrayQueue03<Integer> queue = new ArrayQueue03<>(5);

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

//        boundary();

//        Map<String,Object> map = new ConcurrentHashMap<>();
//        map.putIfAbsent("aaa","ddd");
//        map.putIfAbsent("aaa","ccc");
//        System.out.println(map.get("aaa"));

    }

    public static void boundary(){
        ArrayQueue03<Integer> queue = new ArrayQueue03<>(10);
        // 2147483647 正整数的最大值 int
        queue.head = 2147483640;
        queue.tail = queue.head;;

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
