package site.techland.algorithm.leetcode;

/**
 * @author liquanfeng
 * @date 2025/8/8
 * @description 反转链表
 */
public class E0206ReverseList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        for (int i = 2; i < 6; i++) {
            ListNode tmp = new ListNode(i);
            node.next = tmp;
            node.next = node;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            ListNode tmp = new ListNode(head.val);
            tmp.next = res;
            res.next = tmp;
        }
        return res;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
