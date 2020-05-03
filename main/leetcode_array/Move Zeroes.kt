package main.leetcode_array

fun moveZeroes(nums: IntArray): Unit {
    var j = 0
    nums.forEachIndexed { i, num ->
        j = i
        if (num == 0) {
            while (j < nums.size - 1 && nums[j] == 0) {
                j++
            }
            nums[i] = nums[j].also { nums[j] = nums[i] }
        }
    }
}