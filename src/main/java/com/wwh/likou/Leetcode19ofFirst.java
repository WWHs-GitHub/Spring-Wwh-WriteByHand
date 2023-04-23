package com.wwh.likou;

/**
 * 删除倒数节点 - 解法一(递归)
 */
public class Leetcode19ofFirst {

    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode s = new ListNode(-1,head);
        recursion(s,n);
        return s.next;
    }

    public static int recursion(ListNode p,int n){
        if (p == null){
            return 0;
        }

        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        System.out.println(p.val + " " + nth);

        if (nth == n){
            p.next = p.next.next;
        }

        return nth + 1;
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
