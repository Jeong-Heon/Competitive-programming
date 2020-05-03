package main.leetcode_array

fun sortArrayByParity(A: IntArray): IntArray {
    var j = 0
    A.forEachIndexed { i, num ->
        j = i
        if (num.rem(2) != 0) {
            while (j < A.size - 1 && A[j].rem(2) != 0) j++
            A[i] = A[j].also { A[j] = A[i] }
        }
    }
    return A
}