package com.wwh.likou;

import java.util.Arrays;

/**
 * 合并k个有序链表 - 解法一
 */
public class Leetcode23ofFirst {

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

    public static ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        return split(lists,0, lists.length - 1);
    }

    // 返回合并后的链表，i,j 代表左右边界
    public static ListNode split(ListNode[] lists,int i,int j){
        if (i == j){  // 数组内只有一个链表
            return lists[i];
        }

        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left,right);
    }


    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode l9 = new ListNode(9,null);
        ListNode l8 = new ListNode(2,l9);
        ListNode l7 = new ListNode(6,l8);
        ListNode l6 = new ListNode(1,l7);
        ListNode listNode2 = new ListNode(0,l6);

        ListNode l13 = new ListNode(10,null);
        ListNode l12 = new ListNode(9,l13);
        ListNode l11 = new ListNode(4,l12);
        ListNode l10 = new ListNode(13,l11);
        ListNode listNode3 = new ListNode(24,l10);

        ListNode[] listNodes =new ListNode[]{listNode,listNode2,listNode3};

//        ListNode resultList = mergeTwoLists(listNode,listNode2);
        ListNode resultList = mergeKLists(listNodes);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
