package main.leetcode_linked_list

class `Odd Even Linked List` {
    class Solution {
        fun oddEvenList(head: ListNode?): ListNode? {
            var odd = head
            var even = head?.next
            val evenFirst = even

            while (odd?.next != null && even?.next != null) {
                odd.next = even.next
                odd = odd.next
                even.next = odd?.next
                even = even.next
            }
            odd?.next = evenFirst

            return head
        }
    }
}