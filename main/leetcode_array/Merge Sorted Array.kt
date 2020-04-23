package main.leetcode_array

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val zeroIdx = nums1.size - nums2.size
    for (i in nums2.indices) {
        nums1[zeroIdx + i] = nums2[i]
    }
    nums1.sort()
}