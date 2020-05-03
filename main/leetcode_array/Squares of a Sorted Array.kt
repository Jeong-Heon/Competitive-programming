package main.leetcode_array

fun main() {
    val array = intArrayOf(-4, -1, 0, 3, 10)
    sortedSquares(array).forEach { println(it) }
}

fun sortedSquares(A: IntArray): IntArray {
    return A.map { it * it }.sortedWith(Comparator { o1, o2 -> o1 * o1 - o2 * o2 }).toIntArray()
}