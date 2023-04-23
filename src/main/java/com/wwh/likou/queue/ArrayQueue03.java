package com.wwh.likou.queue;

import java.util.Iterator;

public class ArrayQueue03<E> implements Queue<E>, Iterable<E> {

    /*
        求模运算：
            - 如果除数是 2 的 n次方
            - 那么被除数的后 n 位即为余数（模）
            - 求被除数的后 n 位方法：与2^n-1 按位与
     */

    private E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue03(int c) {
        // 1.抛异常
//        if ((capacity & (capacity - 1)) != 0) {
//            throw new IllegalArgumentException("Capacity must be 2 to the nth power");
//        }

        // 2.改成2^n  13->16 30->32
        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        array = (E[]) new Object[c];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
//        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        array[tail & (array.length - 1)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
//        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        E value = array[head & (array.length) - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
//        return array[(int) (Integer.toUnsignedLong(head) % array.length)];
        return array[head & (array.length - 1)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
//                E value = array[(int) (Integer.toUnsignedLong(p)  % array.length)];
                E value = array[p & (array.length) - 1];
                p++;
                return value;
            }
        };
    }

    public static void main(String[] args) {

        // 求离c最近，比c大的2^n（方法一）
        int c = 17;

        /*
            2^4        = 16
            2^4.?      = 30
            2^5        = 32

            那么2^[(int)log2(30) + 1] 就可以把30转成32

            哪么怎么求log2(x)呢？可以利用Math库里的log2(x) = log10(x) / log10(2)
         */

        // 方法一
        // 为什么要Math.log10(c - 1)？因为如果刚好c是2的n次方，这时它会多左移一位，即传入32，输出64
//        int n = (int) (Math.log10(c - 1) / Math.log10(2)) + 1;
//        System.out.println(n);
//        System.out.println(1 << n);

        // 求离c最近，比c大的2^n（方法二）
        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        System.out.println(c);

    }
}
