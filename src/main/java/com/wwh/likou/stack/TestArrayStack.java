package com.wwh.likou.stack;

import java.util.Iterator;

public class TestArrayStack {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.pop();

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
