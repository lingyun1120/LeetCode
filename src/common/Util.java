package common;

public class Util {
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

    public static void preOrderRecursion(TreeNode tree) {
        System.out.println("---> 前序：" + tree.val);
        TreeNode left = tree.left;
        if (left != null) {
            preOrderRecursion(left);
        }
        TreeNode right = tree.right;
        if (right != null) {
            preOrderRecursion(right);
        }
    }

    public static void inOrderRecursion(TreeNode tree) {
        TreeNode left = tree.left;
        if (left != null) {
            inOrderRecursion(left);
        }
        System.out.println("---> 中序：" + tree.val);
        TreeNode right = tree.right;
        if (right != null) {
            inOrderRecursion(right);
        }
    }

    public static void postOrderRecursion(TreeNode tree) {
        TreeNode left = tree.left;
        if (left != null) {
            postOrderRecursion(left);
        }
        TreeNode right = tree.right;
        if (right != null) {
            postOrderRecursion(right);
        }
        System.out.println("---> 后序：" + tree.val);
    }
}
