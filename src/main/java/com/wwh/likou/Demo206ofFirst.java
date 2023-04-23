package com.wwh.likou;

/**
 * 反转链表 - 解法一
 */
public class Demo206ofFirst {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);


        ListNode listNode = reverse(l1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

//        while (l1 != null){
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }
    }

    private static ListNode reverse(ListNode l1) {
        ListNode listNode = null;
        ListNode head = l1;

        while (head != null){
            ListNode l = new ListNode(head.val,listNode);
            listNode = l;
            head = head.next;
        }

        return listNode;
    }
}
