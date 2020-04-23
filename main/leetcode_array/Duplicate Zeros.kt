package main.leetcode_array

fun duplicateZeros(arr: IntArray): Unit {
    var i = 0
    while (i < arr.size) {
        if (arr[i] == 0 && i + 1 < arr.size) {
            for (j in arr.size - 1 downTo i + 2) {
                arr[j] = arr[j - 1]
            }
            arr[++i] = 0
        }
        i++
    }
}