package com.wwh.likou;

/**
 * 删除有序链表重复元素 - 解法一
 */
public class Leetcode876ofFirst {

    public static ListNode middleNode(ListNode head){
        ListNode p1 = head;
        ListNode p2 = p1;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(4,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = middleNode(listNode);
//        System.out.println(last.val);

        System.out.println(resultList.val);
    }
}
