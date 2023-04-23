package com.wwh.likou;

/**
 * 删除有序链表重复元素(重复元素都删除) - 解法二
 */
public class Leetcode82ofSecond {

    /**
     * p1 p2 p3
     * s  1  1  1  2  3  null
     *
     * p1 p2    p3
     * s  1  1  1  2  3  null
     *
     * p1 p2       p3
     * s  1  1  1  2  3  null
     *
     * p1 p3
     * s  2  3  null
     *
     * p1  p2  p3
     * s   2   3   null
     *
     *    p1   p2   p3
     * s  2    3    null
     *
     * @param p
     * @return
     */
    public static ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode s = new ListNode(-1,p);
        ListNode p1 = s;
        ListNode p2,p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null){
            if (p2.val == p3.val){
                while ((p3 = p3.next) != null && p2.val == p3.val){

                }

                // 找到不重复的元素了
                p1.next = p3;
            }else {
                p1 = p1.next;
            }
        }

        return s.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(5, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode listNode = new ListNode(1, l2);

        ListNode resultList = deleteDuplicates(listNode);
//        System.out.println(last.val);

        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
}
