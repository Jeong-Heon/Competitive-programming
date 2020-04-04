package main.hash

fun main() {
    val input1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    println("Problem3 - solution1")
    println("answer: " + solution1(input1))
}

fun solution1(clothes: Array<Array<String>>): Int {
    val map = HashMap<String, Int>()
    clothes.forEach { nameTypePairArray ->
        map[nameTypePairArray[1]] = (map[nameTypePairArray[1]] ?: 0) + 1
    }
    return map.values.fold(1) { acc, value -> acc * (value + 1) } - 1
}

fun solution2(clothes: Array<Array<String>>) = clothes
    .groupBy { it[1] }.values
    .map { it.size + 1 }
    .reduce(Int::times)
    .minus(1)