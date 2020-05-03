package main.leetcode_array

fun main() {
    val arr = intArrayOf(-2, 0, 10, -19, 4, 6, -8)
    print(checkIfExist(arr))
}

fun checkIfExist(arr: IntArray): Boolean {
    for (i in arr.indices) {
        for (j in arr.indices) {
            if (arr[i].rem(2) != 0) continue
            if (i == j) continue
            if (arr[i] == 2 * arr[j]) return true
        }
    }
    return false
}