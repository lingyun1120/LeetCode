package medium

import common.ListNode


object Q2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?) : ListNode? {
        val node = ListNode(0)
        var list1 = l1
        var list2 = l2
        var cur = node
        var sum = 0
        while (list1 != null || list2 != null || sum != 0) {
            if (list1 != null) {
                sum += list1.`val`
                list1 = list1.next
            }
            if (list2 != null) {
                sum += list2.`val`
                list2 = list2.next
            }
            cur.next = ListNode(sum % 10)
            cur = cur.next!!
            sum /= 10
        }
        return node.next
    }
}