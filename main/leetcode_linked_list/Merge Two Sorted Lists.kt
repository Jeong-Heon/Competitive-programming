package main.leetcode_linked_list

class `Merge Two Sorted Lists` {
    class Solution {
        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            if (l1 == null) return l2
            if (l2 == null) return l1

            val head: ListNode? = if (l1.`val` <= l2.`val`) l1 else l2

            var list1: ListNode? = if (head == l1) l1.next else l1
            var list2: ListNode? = if (head == l2) l2.next else l2

            var prev = head

            while (list1 != null && list2 != null) {
                if (list1.`val` <= list2.`val`) {
                    prev?.next = list1
                    prev = list1
                    list1 = list1.next
                } else {
                    prev?.next = list2
                    prev = list2
                    list2 = list2.next
                }
            }

            if (list2 == null) prev?.next = list1
            if (list1 == null) prev?.next = list2

            return head
        }
    }
}