package com.wwh.likou.stack;

import com.wwh.likou.ListNode;
import com.wwh.likou.queue.Node;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private int size;
    private int capacity = Integer.MAX_VALUE;
    public Node<E> head = new Node<E>(null,null);

    public LinkedListStack() {
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * head -> 1 -> null
     * @param value 待压入值
     * @return
     */
    @Override
    public boolean push(E value) {
        if (isFull()){
            return false;
        }
        head.next = new Node<E>(value,head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
