package com.wwh.likou;

/**
 * 反转链表 - 解法四
 *
 */
public class Demo206ofFour {

    public static ListNode reverse(ListNode o1){
        if (o1 == null || o1.next == null){
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;

        while (o2 != null){
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }

        return n1;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = reverse(listNode);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

    }

}
