package main.leetcode_linked_list

class `Intersection Of Two Linked List` {
    class Solution {
        fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

            val lengthA = getListLength(headA)
            val lengthB = getListLength(headB)

            var a = headA
            var b = headB

            if (lengthA > lengthB) {
                a = moveForward(a, lengthA - lengthB)
            } else {
                b = moveForward(b, lengthB - lengthA)
            }

            while (a != null && b != null) {
                if (a == b) return a
                a = a?.next
                b = b?.next
            }

            return null
        }

        fun getListLength(head: ListNode?): Int {
            var node = head
            var length = 0
            while (node != null) {
                length++
                node = node?.next
            }
            return length
        }

        fun moveForward(head: ListNode?, n: Int): ListNode? {
            var node = head
            for (i in 0 until n) {
                node = node?.next
            }
            return node
        }
    }

    class Solution2 {
        fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

            if (headA == null || headB == null) {
                return null
            }

            var a = headA
            var b = headB

            while (a != b) {
                a = if (a == null) headB else a.next
                b = if (b == null) headA else b.next
            }

            return a
        }

    }
}