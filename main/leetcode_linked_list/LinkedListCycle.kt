package main.leetcode_linked_list

class LinkedListCycle {
    class Solution {
        fun hasCycle(head: ListNode?): Boolean {
            if (head == null || head?.next == null) return false

            var n1 = head
            var n2 = head?.next

            if (n2?.next == null) return false

            while (n1 != n2) {
                n1 = n1?.next
                n2 = n2?.next ?: return false
                if (n1 == n2) return true
                n2 = n2?.next ?: return false
            }

            if (n1?.next == null) return false
            return true

        }
    }
}