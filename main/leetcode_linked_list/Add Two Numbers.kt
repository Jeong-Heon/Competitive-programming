package main.leetcode_linked_list

class `Add Two Numbers` {
    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var l1 = l1
            var l2 = l2
            var resultHead = ListNode(0)
            var result: ListNode? = resultHead
            var carry = 0

            while (l1 != null || l2 != null || carry != 0) {

                val n1 = l1?.`val` ?: 0
                val n2 = l2?.`val` ?: 0

                var num = (n1 + n2 + carry)
                carry = if (num > 9) 1 else 0
                num = num.rem(10)

                result?.next = ListNode(num)
                result = result?.next

                l1 = if (l1 == null) l1 else l1.next
                l2 = if (l2 == null) l2 else l2.next

            }

            return resultHead.next
        }
    }
}