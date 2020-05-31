package main.leetcode_linked_list

import kotlin.math.sign

class `Rotate List` {
    class Solution {
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            if (head?.next == null) return head
            var length = 0
            var cur: ListNode? = ListNode(-1)
            cur?.next = head
            while (cur?.next != null) {
                cur = cur?.next
                length++
            }
            cur?.next = head

            var moveHeadCount = length - k
            moveHeadCount = moveHeadCount.rem(length)
            if (moveHeadCount < 0) moveHeadCount += length

            cur = head
            while (moveHeadCount > 0) {
                cur = cur?.next
                moveHeadCount--
            }

            val result = cur

            while (length > 1) {
                cur = cur?.next
                length--
            }
            cur?.next = null

            return result
        }
    }

    class Solution2 {
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            var length = 1
            var cur = head
            while (cur?.next != null) {
                cur = cur.next
                length++
            }
            var tail = cur

            cur = head
            tail?.next = head

            for (i in 0 until length - (k % length)) {
                cur = cur?.next
                tail = tail?.next
            }
            tail?.next = null

            return cur
        }
    }
}