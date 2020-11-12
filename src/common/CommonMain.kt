package common

fun main() {
    /**
     *          0
     *       /    \
     *      1      2
     *     /  \   / \
     *    3   4  5  6
     *   /\  /\ /\ /\
     *  7 8 9
     *
     */
    val node = arrayOfNulls<TreeNode>(10) //以数组形式生成一棵完全二叉树

    for (i in 0..9) {
        node[i] = TreeNode(i)
    }
    for (i in 0..9) {
        if (i * 2 + 1 < 10) node[i]!!.left = node[i * 2 + 1]
        if (i * 2 + 2 < 10) node[i]!!.right = node[i * 2 + 2]
    }
    TreeNode.bfs(node[0])
    print("---------------------------\n")
    TreeNode.preOrderRecursion(node[0])
    print("---------------------------\n")
    TreeNode.preOrder(node[0])
    print("---------------------------\n")
    TreeNode.inOrderRecursion(node[0])
    print("---------------------------\n")
    TreeNode.inOrder(node[0])
    print("---------------------------\n")
    TreeNode.postOrderRecursion(node[0])
    print("---------------------------\n")
    TreeNode.postOrder(node[0])
    print("---------------------------\n")
    TreeNode.bfsRecursion(node[0])
    print("---------------------------\n")
    TreeNode.bfs(node[0])
}