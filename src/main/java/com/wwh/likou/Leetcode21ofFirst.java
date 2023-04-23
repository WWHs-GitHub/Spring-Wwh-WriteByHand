package com.wwh.likou;

/**
 * 合并有序链表 - 解法一
 */
public class Leetcode21ofFirst {

    public static ListNode mergeTwoLists(ListNode p1,ListNode p2){
        ListNode s = new ListNode(-1,null);
        ListNode p = s;

        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null){
            p.next = p1;
        }

        if (p2 != null){
            p.next = p2;
        }

        return s.next;
    }


    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode l9 = new ListNode(9,null);
        ListNode l8 = new ListNode(2,l5);
        ListNode l7 = new ListNode(6,l4);
        ListNode l6 = new ListNode(1,l3);
        ListNode listNode2 = new ListNode(0,l2);

        ListNode resultList = mergeTwoLists(listNode,listNode2);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
