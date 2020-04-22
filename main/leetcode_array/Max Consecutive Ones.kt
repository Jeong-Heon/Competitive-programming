package main.leetcode_array

fun main() {
    val array = intArrayOf(1, 0, 1, 1, 0, 1)
    print(findMaxConsecutiveOnes(array))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var cnt = 0
    nums.forEachIndexed { idx, it ->
        cnt += it
        if (it == 0 || idx == nums.size - 1) {
            if (max < cnt) max = cnt
            cnt = 0
        }
    }
    return max
}