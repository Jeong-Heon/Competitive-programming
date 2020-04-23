package main.leetcode_array

fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty()) return 0

    var start = 0
    var end = nums.lastIndex

    while (start < end) {
        if (nums[end] == `val`) end--
        if (nums[start] != `val`) start++
        if (start >= end) break
        if (nums[end] != `val` && nums[start] == `val`) {
            nums[start] = nums[end].also { nums[end] = nums[start] }
            start++
            end--
        }
    }

    return if (nums[start] == `val`) start else start + 1
}