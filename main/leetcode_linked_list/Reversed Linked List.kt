package main.leetcode_linked_list

class `Reversed Linked List` {
    class Solution {
        fun reverseList(head: ListNode?): ListNode? {
            var newHead = head

            while (head?.next != null) {
                val prevHead = newHead
                newHead = head.next!!
                head.next = newHead.next
                newHead.next = prevHead
            }

            return newHead
        }
    }

    class Solution2 {
        fun reverseList(head: ListNode?): ListNode? {
            return getNewHead(head, head)
        }

        private tailrec fun getNewHead(originHead: ListNode?, prevHead: ListNode?): ListNode? {
            if (originHead?.next == null) {
                return prevHead
            }
            val newHead = originHead.next
            originHead.next = newHead?.next
            newHead?.next = prevHead
            return getNewHead(originHead, newHead)
        }
    }

    class Solution3 {
        fun reverseList(head: ListNode?): ListNode? {
            var prev: ListNode? = null
            var cur = head

            while (cur != null) {
                var next = cur.next
                cur.next = prev
                prev = cur
                cur = next
            }

            return prev
        }
    }

    class Solution4 {
        fun reverseList(head: ListNode?): ListNode? {
            if (head?.next == null) return head
            val p = reverseList(head.next)
            head.next!!.next = head
            head.next = null
            return p
        }
    }
}