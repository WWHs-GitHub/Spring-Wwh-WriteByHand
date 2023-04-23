package com.wwh.likou.stack;

public class E04Leetcode232 {

    /*
        队列头             队列尾

        顶    底         底     顶
        s1                     s2

        队列尾添加
            s2.push(a)
            s2.push(b)

        队列头移除
            先把 s2 的所有元素移动到 s1
            s1.pop()
     */

    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    // 向队列尾添加
    public void push(int x){
        s2.push(x);
    }

    // 从队列头移除
    public int pop(){
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            if (!s1.isEmpty()){
                return s1.pop();
            }else {
                return -1;
            }
        }
        return s1.pop();
    }

    // 从队列头获取
    public int peek(){
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            if (!s1.isEmpty()){
                return s1.peek();
            }else {
                return -1;
            }
        }
        return s1.peek();
    }

    public boolean empty(){
        return s2.isEmpty() && s1.isEmpty();
    }

    public static void main(String[] args) {
        E04Leetcode232 e04Leetcode232 = new E04Leetcode232();
        e04Leetcode232.push(1);
        e04Leetcode232.push(2);
        System.out.println(e04Leetcode232.pop());
        System.out.println(e04Leetcode232.pop());
        System.out.println(e04Leetcode232.pop());
    }
}
