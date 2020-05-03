package main.leetcode_array

fun main() {
    val arr = intArrayOf(3, 5, 5)
    print(validMountainArray(arr))
}

fun replaceElements(arr: IntArray): IntArray {
    var i = 0
    while (i < arr.size - 1) {
        var max = 0
        var maxIdx = 0
        for (idx in i + 1 until arr.size) {
            if (max < arr[idx]) {
                max = arr[idx]
                maxIdx = idx
            }
        }
        for (i in i until maxIdx) {
            arr[i] = max
        }
        i = maxIdx
    }
    arr[i] = -1
    return arr
}