package com.wwh.likou;

/**
 * 判断链表是否有环
 */
public class Leetcode141ofFirst {

    public static boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟

        while (h != null && h.next != null){
            h = h.next.next;
            t = t.next;
            if (h == t){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode listNode = new ListNode(1, l2);

        l5.next = l3;

        boolean resultList = hasCycle(listNode);
        System.out.println(resultList);
    }
}
