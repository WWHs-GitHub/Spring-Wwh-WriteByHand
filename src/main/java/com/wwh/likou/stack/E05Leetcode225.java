package com.wwh.likou.stack;

import com.wwh.likou.queue.ArrayQueue03;

public class E05Leetcode225 {

    /*
        push 添加
            - 将新加入元素，前面的所有元素从队列头移动到队列尾
        pop 移除
            - 直接移除队列头元素
     */

    ArrayQueue03<Integer> queue = new ArrayQueue03<>(100);
    private int size = 0;


    public void push(int x){
        queue.offer(x);

        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }

        size++;
    }


    public int pop(){
        if (queue.isEmpty()){
            return -1;
        }

        size--;
        return queue.poll();
    }


    public int top(){
        if (queue.isEmpty()){
            return -1;
        }

        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}
