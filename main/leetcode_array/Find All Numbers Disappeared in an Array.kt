package main.leetcode_array


fun main() {
    val arr = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    findDisappearedNumbers(arr).forEach {
        println(it)
    }
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val counts = nums.copyOf().apply { fill(0) }
    nums.forEach {
        counts[it - 1]++
    }
    return counts.withIndex().filter { it.value == 0 }.map { it.index + 1 }
}