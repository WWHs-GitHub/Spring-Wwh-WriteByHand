package com.wwh.likou;

/**
 * 根据值删除节点 - 解法二(递归)
 */
public class Leetcode203ofSecond {

    public static ListNode removeElements(ListNode p,int val){
        if (p == null){
            return null;
        }

        if (p.val == val){
            return removeElements(p.next,val);
        }else {
            p.next = removeElements(p.next,val);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        ListNode resultList = removeElements(listNode,3);
//        System.out.println(last.val);

        while (resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }

    }
}
