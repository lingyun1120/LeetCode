package offer

import common.TreeNode


/**
 * 剑指Offer
 */
fun main() {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)
    val t5 = TreeNode(5)
    val t6 = TreeNode(6)
    val t7 = TreeNode(7)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    t3.right = t7

    val tt3 = TreeNode(3)
    val tt6 = TreeNode(6)
    val tt7 = TreeNode(7)
    tt3.left = tt6
    tt3.right = tt7

    Solutions.isSubStructure(t1, tt3)
}