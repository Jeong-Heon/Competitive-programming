package main.leetcode_array

fun main() {
    val arr = intArrayOf(5, 1, 2, 3, 4)
    println(heightChecker(arr))
}

fun heightChecker(heights: IntArray): Int {
    val sortedArr = heights.sortedArray()
    var cnt = 0

    sortedArr.forEachIndexed { index, height ->
        if (heights[index] != height) cnt++
    }

    return cnt
}