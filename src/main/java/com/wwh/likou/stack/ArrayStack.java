package com.wwh.likou.stack;

import com.wwh.likou.queue.Node;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E>{

    private int capacity = Integer.MAX_VALUE;
    private E[] array;
    private int tail = 0; // 栈顶指针


    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()){
            return false;
        }
        array[tail++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        return array[--tail];
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return array[tail - 1];
    }

    @Override
    public boolean isEmpty() {
        return tail == 0;
    }

    @Override
    public boolean isFull() {
        return array.length == tail;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return tail > 0;
            }

            @Override
            public E next() {
                return array[--tail];
            }
        };
    }
}
