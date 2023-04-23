package com.wwh.likou;

/**
 * 根据值删除节点
 */
public class Leetcode203ofFirst {

    public static ListNode removeElements(ListNode head,int val){
        // 哨兵(如果不加哨兵，则删除第一个节点要特殊处理)
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s.next;

        while (p2 != null){
            // 值相等
            // p2等于val，删除它，注意p1此时保持不变，p2向后移
            if (p2.val == val){
                p1.next = p2.next;
                p2 = p1.next;
            }
            // 如果p2不等于目标，则p2，p2不断后移
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return s.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(7,null);
        ListNode l4 = new ListNode(7,l5);
        ListNode l3 = new ListNode(7,l4);
        ListNode l2 = new ListNode(7,l3);
        ListNode listNode = new ListNode(7,l2);

        ListNode resultList = removeElements(listNode,7);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

    }
}
