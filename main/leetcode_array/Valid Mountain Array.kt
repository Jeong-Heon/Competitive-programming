package main.leetcode_array

fun main() {
    val arr = intArrayOf(3, 5, 5)
    print(validMountainArray(arr))
}

fun validMountainArray(A: IntArray): Boolean {
    if (A.size < 3) return false

    var point = Int.MIN_VALUE

    for (i in 1 until A.size - 1) {
        if (A[i-1] < A[i] && A[i] > A[i+1]) {
            point = i
            break
        }
    }

    if (point == Int.MIN_VALUE) return false

    for (i in 0 until point) {
        if (A[i] >= A[i+1]) return false
    }
    for (i in point + 1 until A.size - 1) {
        if (A[i] <= A[i+1]) return false
    }

    return true
}