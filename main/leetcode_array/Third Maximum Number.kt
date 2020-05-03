package main.leetcode_array

fun main() {
    val arr = intArrayOf(2, 2, 3, 1)
    println(thirdMax(arr))
}

fun thirdMax(nums: IntArray): Int {
    var first: Int? = null
    var second: Int? = null
    var third: Int? = null

    first = nums.max()
    second = nums.filter { it != first }.max()
    third = nums.filter { it != first && it != second }.max()

    return third ?: first ?: Int.MIN_VALUE
}