package main.leetcode_linked_list

class `Remove Nth Node From End Of List` {

    class Solution {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var n1 = head
            var n2 = head

            for (i in 0 until n) {
                n2 = n2?.next
            }

            while (n2 != null) {
                n1 = n1?.next
                n2 = n2.next
            }

            var n3 = head

            if (n1 == n3) return head?.next
            while (n3?.next != n1) {
                n3 = n3?.next
            }
            n3?.next = n1?.next

            return head

        }

    }

    class Solution2 {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val start: ListNode? = ListNode(0)
            start?.next = head

            var fast = start
            for (i in 1..n+1) {
                fast = fast?.next
            }

            var slow = start
            while (fast != null) {
                fast = fast.next
                slow = slow?.next
            }

            slow?.next = slow?.next?.next

            return start?.next
        }
    }
}


/*
* // Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
* */