package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int value) { val = value; }

    /**
     * 反转链表
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
