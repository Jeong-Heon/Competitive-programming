package main.leetcode_array

import kotlin.math.log10

fun main() {
    val array = intArrayOf(12, 345, 2, 6, 7896)
    print(findMaxConsecutiveOnes(array))
}

fun findNumbers(nums: IntArray): Int {
    return nums.count { log10(it.toFloat()).toInt().plus(1).rem(2) == 0 }
}