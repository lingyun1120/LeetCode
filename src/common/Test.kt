package common

fun main() {

    val node = arrayOfNulls<TreeNode>(10) //以数组形式生成一棵完全二叉树

    for (i in 0..9) {
        node[i] = TreeNode(i)
    }
    for (i in 0..9) {
        if (i * 2 + 1 < 10) node[i]!!.left = node[i * 2 + 1]
        if (i * 2 + 2 < 10) node[i]!!.right = node[i * 2 + 2]
    }
    Util.preOrderRecursion(node[0])
    print("-----------\n")
    Util.inOrderRecursion(node[0])
    print("-----------\n")
    Util.postOrderRecursion(node[0])
}