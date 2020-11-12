package common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**DFS============================================================================================================*/
    /*** 前序遍历-递归*/
    public static void preOrderRecursion(TreeNode tree) {
        System.out.println("---> 前序递归：" + tree.val);
        TreeNode left = tree.left;
        if (left != null) {
            preOrderRecursion(left);
        }
        TreeNode right = tree.right;
        if (right != null) {
            preOrderRecursion(right);
        }
    }

    /*** 前序遍历-非递归*/
    public static void preOrder(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.println("---> 前序非递归：" + node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**================================================================================================================*/
    /*** 中序遍历-递归*/
    public static void inOrderRecursion(TreeNode tree) {
        TreeNode left = tree.left;
        if (left != null) {
            inOrderRecursion(left);
        }
        System.out.println("---> 中序递归：" + tree.val);
        TreeNode right = tree.right;
        if (right != null) {
            inOrderRecursion(right);
        }
    }

    /**================================================================================================================*/
    /*** 中序遍历-非递归*/
    public static void inOrder(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println("---> 中序非递归：" + node.val);
                node = node.right;
            }
        }
    }

    /**================================================================================================================*/
    /*** 后序遍历-递归*/
    public static void postOrderRecursion(TreeNode tree) {
        TreeNode left = tree.left;
        if (left != null) {
            postOrderRecursion(left);
        }
        TreeNode right = tree.right;
        if (right != null) {
            postOrderRecursion(right);
        }
        System.out.println("---> 后序递归：" + tree.val);
    }

    /*** 后序遍历-非递归*/
    public static void postOrder(TreeNode tree) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (tree != null || !stack1.empty()) {
            while (tree != null) {
                stack1.push(tree);
                stack2.push(0);
                tree = tree.left;
            }

            while (!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.println("---> 后序递归：" + stack1.pop().val);
            }

            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                tree = stack1.peek();
                tree = tree.right;
            }
        }
    }

    /**================================================================================================================*/
    /*** BFS 广度优先搜索 递归*/
    public static void bfsRecursion(TreeNode tree) {
        //一般来说不能使用递归来实现BFS，因为BFS使用的时队列实现，而递归使用的是栈实现。
    }

    /*** BFS 广度优先搜索 非递归*/
    public static void bfs(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //队列需要使用linkedlist来初始化
        if (tree == null)
            return;
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("---> BFS非递归：" + node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}
