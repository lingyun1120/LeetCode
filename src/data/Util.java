package data;

public class Util {
    public static void printList(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        System.out.println("----> " + sb.toString());
    }

    public static void printTree(TreeNode root) {

    }
}
