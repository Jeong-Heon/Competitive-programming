package main.leetcode_linked_list

fun main() {
    MyLinkedList()
}

class MyLinkedList {

    /** Initialize your data structure here. */
    data class Node(var `val`: Int = 0, var next: Node? = null)

    private var head: Node? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        if (head == null) return -1
        var cur = head!!
        var cnt = 0
        while (cnt != index && cur.next != null) {
            cur = cur.next!!
            cnt++
        }
        return if (cnt == index) cur.`val` else -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        head = Node(`val`).apply {
            next = head
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
        } else {
            var cur = head
            while (cur?.next != null) {
                cur = cur.next
            }
            cur?.next = Node(`val`)
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (head == null || index == 0) addAtHead(`val`)
        var cur = head!!
        var cnt = 0
        while (cnt != index - 1 && cur.next != null) {
            cur = cur.next!!
            cnt++
        }
        if (cur.next == null) addAtTail(`val`)
        else {
            cur.next = Node(`val`).apply { next = cur.next }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (head == null) return
        if (index == 0) {
            head = head!!.next
            return
        }
        var cur = head!!
        var cnt = 0
        while (cnt != index - 1 && cur.next != null) {
            cur = cur.next!!
            cnt++
        }
        if (cur.next == null) return
        else {
            cur.next = cur.next!!.next
        }
    }

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