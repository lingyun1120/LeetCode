package offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q27 {
    public static TreeNode mirrorTreeBFS(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return null;
        //队列
        final Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            //交换node节点的两个子节点
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //如果当前节点的左子树不为空，就把左子树
            //节点加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            //如果当前节点的右子树不为空，就把右子树
            //节点加入到队列中
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    public static TreeNode mirrorTreeDFS(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return null;
        //栈
        Stack<TreeNode> stack = new Stack<>();
        //根节点压栈
        stack.push(root);
        //如果栈不为空就继续循环
        while (!stack.empty()) {
            //出栈
            TreeNode node = stack.pop();
            //子节点交换
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            //左子节点不为空入栈
            if (node.left != null)
                stack.push(node.left);
            //右子节点不为空入栈
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }

    public static TreeNode mirrorTreeInOrder(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return null;
        //栈
        Stack<TreeNode> stack = new Stack<>();
        //根节点压栈
        stack.push(root);
        //如果栈不为空就继续循环
        while (!stack.empty()) {
            //出栈
            TreeNode node = stack.pop();
            //子节点交换
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            //左子节点不为空入栈
            if (node.left != null)
                stack.push(node.left);
            //右子节点不为空入栈
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }
}
