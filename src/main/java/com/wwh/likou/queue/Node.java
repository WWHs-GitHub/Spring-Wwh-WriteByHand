package com.wwh.likou.queue;

public class Node<E>{
    public E value;
    public Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}
