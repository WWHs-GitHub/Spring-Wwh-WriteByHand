package com.wwh.likou;

/**
 * 回文链表 - 解法二(解法一优化)
 */
public class Leetcode234ofSecond {

    /**
     * 步骤一：找中间点及前半个链表反转
     * 步骤二：反转后链表与原链表后半链表逐一比较
     */
    public static boolean isPalindrome(ListNode head){
        ListNode p1 = head;
        ListNode p2 = p1;
        ListNode o1 = p1;
        ListNode n1 = null;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }

        ListNode reverseList = n1;

        if (p2 != null){
            p1 = p1.next;
        }

        while (p1 != null){
            if (p1.val != reverseList.val){
                return false;
            }
            p1 = p1.next;
            reverseList = reverseList.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l6 = new ListNode(6,null);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(3,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(5,l3);
        ListNode listNode = new ListNode(6,l2);

        System.out.println(isPalindrome(listNode));

    }
}
