package com.wwh.likou;

/**
 * 回文链表 - 解法一
 */
public class Leetcode234ofFirst {

    /**
     * 步骤一：找中间点
     * 步骤二：中间点半个链表反转
     * 步骤三：反转后链表与原链表逐一比较
     */
    public static boolean isPalindrome(ListNode head){
        ListNode middle = middle(head);
//        System.out.println(middle.val);
        ListNode reverseList = reverse(middle);

        while (reverseList != null){
            if (reverseList.val != head.val){
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null){
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }

        return n1;
    }

    private static ListNode middle(ListNode head) {
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
        ListNode l4 = new ListNode(3,l5);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(3,l3);
        ListNode listNode = new ListNode(5,l2);

        System.out.println(isPalindrome(listNode));

    }
}
