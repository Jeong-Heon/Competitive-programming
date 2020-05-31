package main.leetcode_linked_list

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class `Copy List with Random Pointer` {
    class Solution {
        fun copyRandomList(node: Node?): Node? {
            if (node == null) return null

            var copiedNode: Node?

            var cur: Node? = node
            while (cur != null) {
                copiedNode = Node(cur.`val`)
                val next = cur.next
                cur.next = copiedNode
                copiedNode.next = next
                cur = next
            }

            val result = node.next

            cur = node
            while (cur != null) {
                val copiedNode = cur.next
                val originNext = cur.next?.next
                copiedNode?.random = cur.random?.next
                cur = originNext
            }

            cur = node
            while (cur != null) {
                val copiedNode = cur.next
                cur.next = cur.next?.next
                copiedNode?.next = copiedNode?.next?.next
                cur = cur.next
            }

            return result
        }
    }
}