package com.wwh.likou;

/**
 * 删除有序链表重复元素 - 解法二(递归)
 */
public class Leetcode83ofSecond {

    public static ListNode deleteDuplicates(ListNode p){
        if (p == null || p.next == null){
            return p;
        }

       if (p.val == p.next.val){
           return deleteDuplicates(p.next);
       }else {
           p.next = deleteDuplicates(p.next);
           return p;
       }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(4,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = deleteDuplicates(listNode);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
