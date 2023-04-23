package com.wwh.likou;

/**
 * 检测环的入口
 */
public class Leetcode142ofFirst {

    public static ListNode detectCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟

        while (h != null && h.next != null){
            h = h.next.next;
            t = t.next;
            if (h == t){
                // 进入第二阶段
                t = head;
                while (t != h){
                    t = t.next;
                    h = h.next;
                }
                return t;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode listNode = new ListNode(1, l2);

        l5.next = listNode;

        ListNode resultList = detectCycle(listNode);
        assert resultList != null;
        System.out.println(resultList.val);
    }
}
