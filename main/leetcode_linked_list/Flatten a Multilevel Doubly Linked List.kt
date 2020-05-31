package main.leetcode_linked_list

class `Flatten a Multilevel Doubly Linked List` {

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }

    class Solution {
        fun flatten(root: Node?): Node? {
            var cur = root
            while (cur != null) {
                val child = cur.child
                if (child != null) {
                    flat(cur.next, child)
                    cur.next = child
                    child?.prev = cur
                    cur.child = null
                    cur = child
                } else {
                    cur = cur.next
                }
            }
            return root
        }

        private fun flat(atTail: Node?, child: Node?) {
            var cur = child
            while (cur?.next != null) {
                cur = cur.next
            }
            cur?.next = atTail
            atTail?.prev = cur
        }
    }
}