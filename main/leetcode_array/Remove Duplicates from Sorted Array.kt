package main.leetcode_array

fun removeDuplicates(nums: IntArray): Int {
    var preValue = Int.MIN_VALUE
    var searchIdx = 0
    var frontIdx = 0

    while (searchIdx < nums.size) {
        if (preValue < nums[searchIdx]) {
            preValue = nums[searchIdx]
            nums[frontIdx] = nums[searchIdx].also { nums[searchIdx] = nums[frontIdx] }
            frontIdx++
        }
        searchIdx++
    }
    return frontIdx
}