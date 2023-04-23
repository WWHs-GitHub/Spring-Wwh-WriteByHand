package com.wwh.likou.deque;

import java.util.Iterator;

/**
 * 基于双向环形链表实现
 * @param <E>
 */
public class LinkedListDeque<E> implements Deque<E>,Iterable<E> {

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private int capacity;
    private int size;
    private Node<E> sentinel = new Node<>(null,null,null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a,e,b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a,e,b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()){
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = a.next;
        Node<E> b = removed.next;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()){
            return null;
        }
        Node<E> a = sentinel.prev.prev;
        Node<E> removed = sentinel.prev;
        Node<E> b = sentinel;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()){
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()){
            return null;
        }
        return sentinel.prev.value;
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
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);

        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
