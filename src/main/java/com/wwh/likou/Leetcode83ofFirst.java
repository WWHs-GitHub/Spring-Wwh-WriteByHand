package com.wwh.likou;

/**
 * 删除有序链表重复元素 - 解法一
 */
public class Leetcode83ofFirst {

    public static ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

       ListNode p1 = head;
       ListNode p2 = head.next;

       while (p2 != null){
           if (p1.val == p2.val){
               p1.next = p2.next;
               p2 = p1.next;
           }else {
               p1 = p1.next;
               p2 = p2.next;
           }
       }

       return head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(4,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = deleteDuplicates(listNode);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
