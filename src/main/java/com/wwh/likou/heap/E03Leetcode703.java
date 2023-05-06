package com.wwh.likou.heap;

/**
 * 求数据流中第k大的元素
 */
public class E03Leetcode703 {

    private MinHeap minHeap;

    public E03Leetcode703(int k,int[] nums){
        minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    // 此方法会被不断调用，模拟数据流中新来的元素
    public int add(int val){
        if (!minHeap.isFull()){
            minHeap.offer(val);
        } else if (val > minHeap.peek()){
            minHeap.replace(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        E03Leetcode703 test = new E03Leetcode703(3, new int[]{4, 5, 8, 2});

        test.add(3);
        test.add(5);
        test.add(10);
        test.add(9);
        test.add(4);
        test.add(6);
        System.out.println(test.add(1));

    }
}
