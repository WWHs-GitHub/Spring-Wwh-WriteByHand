package com.wwh.likou;

import java.util.Arrays;

/**
 * 合并两个有序数组 - 解法二(非递归)
 */
public class Merge2SortedArray2 {

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = 0;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k++] = a1[i++];
            } else {
                a2[k++] = a1[j++];
            }
        }

        if (i <= iEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
        if (j <= jEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 5, 2, 3, 6, 7};
        int[] a2 = new int[a1.length];
        merge(a1, 0, 1, 2, 5, a2);
        System.out.println(Arrays.toString(a2));
    }
}
