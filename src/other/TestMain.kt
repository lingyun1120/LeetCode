package other

import common.ListNode

fun main() {
//    Solutions.threadPrint()
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l2
    val node = Solutions.EntryNodeOfLoop(l1)
    print("入口结点：" + node.`val`)
}