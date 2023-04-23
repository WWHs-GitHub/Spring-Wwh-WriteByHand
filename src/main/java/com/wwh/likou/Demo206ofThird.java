package com.wwh.likou;

/**
 * 反转链表 - 解法三
 * 递归
 */
public class Demo206ofThird {

    public static ListNode reverseOfRecurrence(ListNode p){
        if (p == null || p.next == null){
            return p; // 最后节点
        }

        ListNode last = reverseOfRecurrence(p.next);

        // p.next = 5,p = 4  (p.next.next = p ====> 5.next = 4)
        // p.next = null (4 = null)  ==> 防止造成死循环
        p.next.next = p;
        p.next = null;

        return last;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = reverseOfRecurrence(listNode);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

    }

}
