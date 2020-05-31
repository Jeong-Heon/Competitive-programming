package main.leetcode_linked_list

class LinkedListCycle2 {
    class Solution {
        fun detectCycle(head: ListNode?): ListNode? {

            var n1 = head
            var n2 = head

            while (true) {
                n1 = n1?.next
                n2 = n2?.next?.next
                if (n1 == n2) break
            }

            n1 = head

            while (n1 != n2) {
                n1 = n1?.next
                n2 = n2?.next
            }

            return n1
        }
    }
}