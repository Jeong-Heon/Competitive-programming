package main.leetcode_linked_list

class `Remove Linked List Elements` {
    class Solution {
        fun removeElements(head: ListNode?, `val`: Int): ListNode? {
            val prev: ListNode? = ListNode(0)
            prev?.next = head

            var node = prev

            while (node?.next != null) {
                if (node.next?.`val` == `val`) {
                    node.next = node.next?.next
                } else {
                    node = node.next
                }
            }
            return prev?.next
        }
    }
}