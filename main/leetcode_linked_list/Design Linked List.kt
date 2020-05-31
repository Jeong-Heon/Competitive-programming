package main.leetcode_linked_list

class `Design Linked List` {
    class MyLinkedList() {

        /** Initialize your data structure here. */
        private var head: Node? = null
        private var tail: Node? = null
        private var size = 0


        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        fun get(index: Int): Int {
            if (index < 0 || index > size - 1) {
                return -1
            }

            return getNodeAt(index).value
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        fun addAtHead(`val`: Int) {
            val node = Node(`val`)
            if (size == 0) {
                head = node
                tail = node
            } else {
                head!!.prev = node
                node.next = head
                head = node
            }
            size++
        }

        /** Append a node of value val to the last element of the linked list. */
        fun addAtTail(`val`: Int) {
            val node = Node(`val`)
            if (size == 0) {
                head = node
                tail = node
            } else {
                tail!!.next = node
                node.prev = tail
                tail = node
            }
            size++
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        fun addAtIndex(index: Int, `val`: Int) {
            if (index < 0 || index > size) {
                return
            }
            val node = Node(`val`)
            if (index == size) {
                addAtTail(`val`)
                return
            }
            if (index == 0) {
                addAtHead(`val`)
                return
            }
            val curNode = getNodeAt(index)
            curNode.prev!!.next = node
            node.prev = curNode.prev
            node.next = curNode
            curNode.prev = node
            size++
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        fun deleteAtIndex(index: Int) {
            if (index < 0 || index > size - 1) {
                return
            }
            if (index == 0) {
                head = head?.next
                head?.prev = null
                size--
                return
            }
            if (index == size - 1) {
                tail = tail?.prev
                tail?.next = null
                size--
                return
            }
            val node = getNodeAt(index)
            node.prev!!.next = node.next
            node.next!!.prev = node.prev
            size--
        }

        private fun getNodeAt(index: Int): Node {
            if (index < 0 || index > size - 1) {
                throw IllegalArgumentException()
            }
            var curIndex = 0
            var curNode = head
            while (curIndex <= size - 1) {
                if (curIndex == index) {
                    return curNode!!
                }
                curNode = curNode!!.next
                curIndex++
            }

            return curNode!!
        }

        private class Node(
            val value: Int,
            var prev: Node? = null,
            var next: Node? = null
        )
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * var obj = MyLinkedList()
     * var param_1 = obj.get(index)
     * obj.addAtHead(`val`)
     * obj.addAtTail(`val`)
     * obj.addAtIndex(index,`val`)
     * obj.deleteAtIndex(index)
     */
}