package com.wwh.likou;

/**
 * 合并有序链表 - 解法二
 */
public class Leetcode21ofSecond {

    public static ListNode mergeTwoLists(ListNode p1,ListNode p2){
        if (p2 == null){
            return p1;
        }
        if (p1 == null){
            return p2;
        }

        if (p1.val < p2.val){
            p1.next = mergeTwoLists(p1.next,p2);
            return p1;
        }else {
            p2.next = mergeTwoLists(p1,p2.next);
            return p2;
        }
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
