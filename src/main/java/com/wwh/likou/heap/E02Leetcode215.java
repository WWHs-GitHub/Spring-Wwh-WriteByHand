package com.wwh.likou.heap;

/**
 * 求数组中第k大元素
 * <p>
 * 解题思路：
 * 1.向小顶堆放入前k个元素
 * 2.剩余元素
 *      * 若 <= 堆顶元素，则跳过
 *      * 若 > 堆顶元素，则替换堆顶元素
 * 3.这样小顶堆始终保持为到目前为止，前k大的元素
 * 4.循环结束，堆顶元素即为第k大元素
 */
public class E02Leetcode215 {

    public int findkthLargest(int[] numbers, int k) {
        MinHeap minHeap = new MinHeap(k);
        // 1.向小顶堆放入前k个元素
        for (int i = 0; i < k; i++) {
            minHeap.offer(numbers[i]);
        }
        // 2.剩余元素
        for (int i = k; i < numbers.length; i++) {
            if (numbers[i] > minHeap.peek()){
                // 替换堆顶元素
                minHeap.replace(numbers[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // 应为5
        System.out.println(new E02Leetcode215().findkthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // 应为4
        System.out.println(new E02Leetcode215().findkthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
