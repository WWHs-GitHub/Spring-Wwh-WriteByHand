package com.wwh.likou;

/**
 * 删除有序链表重复元素(重复元素都删除) - 解法一
 */
public class Leetcode82ofFirst {

    public static ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        // 重复
        if (p.val == p.next.val){
            ListNode x = p.next.next;
            while (x != null && x.val == p.val){
                x = x.next;
            }

            // 退出循环后x就是与p的值不同或者为空
            return deleteDuplicates(x);
        }else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode listNode = new ListNode(1, l2);

        ListNode resultList = deleteDuplicates(listNode);
//        System.out.println(last.val);

        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
