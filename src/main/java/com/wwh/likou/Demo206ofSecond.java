package com.wwh.likou;

/**
 * 反转链表 - 解法二
 */
public class Demo206ofSecond {

    static class List{
        private ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (head != null){
                head = first.next;
            }

            return first;
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode listNode = new ListNode(1,l2);

        List list = new List(listNode);
        List resultList = new List(null);

        while (true){
            ListNode first = list.removeFirst();
            if (first == null){
                break;
            }
            resultList.addFirst(first);
        }

        while (resultList.head != null){
            System.out.println(resultList.head.val);
            resultList.head = resultList.head.next;
        }

    }

}
