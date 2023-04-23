package com.wwh.likou;

/**
 * 反转链表 - 解法五
 * 要点：把链表分成两部分，思路就是不断从链表2的头，往链表1的头搬移
 */
public class Demo206ofFive {

    public static ListNode reverse(ListNode o1){
        // 边界条件
        if (o1 == null || o1.next == null){
            return o1;
        }
        // 1  n1指向null,代表新链表一开始没有元素，o1指向原链表的首节点
        ListNode n1 = null;

        // 开始循环
        while (o1 != null){
            // 2  o2指向原链表次节点
            ListNode o2 = o1.next;
            // 3  搬移
            o1.next = n1;
            // 4  指针复位
            n1 = o1;
            o1 = o2;
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
