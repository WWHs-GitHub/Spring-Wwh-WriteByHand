package com.wwh.likou;

/**
 * 删除倒数节点 - 解法二(双指针)
 */
public class Leetcode19ofSecond {

    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }

        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return s.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = removeNthFromEnd(listNode,5);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
