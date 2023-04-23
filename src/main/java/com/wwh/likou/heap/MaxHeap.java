package com.wwh.likou.heap;

import java.util.Arrays;

/**
 * 大顶堆
 */
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MaxHeap(int[] array){
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建堆
    /**
     * 建堆流程：
     * 1.找到最后一个非叶子节点
     * 2.从后向前，对每个节点执行下潜
     */
    private void heapify() {
        // 最后一个非叶子节点：size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 删除堆顶元素
     */
    public int poll() {
        if (size == 0){
            return -1;
        }
        int value = array[0];
        swap(0,size-1);
        size--;
        down(0);
        return value;
    }

    /**
     * 删除指定索引处元素
     */
    public int poll(int index) {
        if (size == 0){
            return -1;
        }
        int value = array[index];
        swap(index,size-1);
        size--;
        down(index);
        return value;
    }

    /**
     * 获取堆顶元素
     */
    public int peek() {
        if (size == 0){
            return -1;
        }
        return array[0];
    }

    /**
     * 堆的尾部添加元素
     */
    public boolean offer(int offered) {
        return false;
    }

    // 将 inserted 元素上浮；直至 offered 小于父元素或到堆顶
    private void up(int offered) {
    }

    // 将 parent 索引处的元素下潜；与两个孩子较大者交换，直至没孩子或者孩子没它大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        // 找到了更到的孩子
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    // 交换两个索引处的元素
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
