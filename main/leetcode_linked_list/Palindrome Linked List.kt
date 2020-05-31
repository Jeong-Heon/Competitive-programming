package main.leetcode_linked_list

class `Palindrome Linked List` {
    class Solution {
        fun isPalindrome(head: ListNode?): Boolean {
            var node = head

            var length = 0
            while (node != null) {
                node = node.next
                length++
            }

            val isEven = length.rem(2) == 0

            var step = length / 2

            var prev: ListNode? = null
            var cur = head

            while (step > 0) {
                var next = cur?.next
                cur?.next = prev
                prev = cur
                cur = next
                step--
            }

            if (!isEven) {
                cur = cur?.next
            }

            while (prev != null && cur != null) {
                if (prev.`val` != cur.`val`) return false
                prev = prev.next
                cur = cur.next
            }
            return true
        }
    }
}