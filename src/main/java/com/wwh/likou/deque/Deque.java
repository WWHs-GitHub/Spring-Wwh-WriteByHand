package com.wwh.likou.deque;

/**
 * 双端队列
 * d:double
 * e:ended
 * que:queue
 * @param <E>
 */
public interface Deque<E> {

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
