package main.hash

fun main() {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = arrayOf(500, 600, 150, 800, 2500).toIntArray()
    println("Problem3 - solution1")
    println("answer: " + solution1(genres, plays).joinToString(","))
}

fun solution1(genres: Array<String>, plays: IntArray): IntArray {
    val indexedPlayPairs = plays.toList().mapIndexed { index, playCount -> Pair(index, playCount) }
    return indexedPlayPairs
        .groupBy { (index, _) -> genres[index] }
        .toList()
        .sortedByDescending { (_, playCounts) ->
            playCounts.map { (_, playCount) -> playCount }.reduce(Int::plus)
        }
        .flatMap { (_, playCounts) ->
            playCounts.sortedByDescending { (_, playCount) -> playCount }.take(2)
        }
        .map { (index, _) -> index }
        .toIntArray()
}

fun solution2(genres: Array<String>, plays: IntArray): Any {
    println(genres.indices)
    return genres.indices.groupBy { genres[it] }
        .toList() // List<Pair<genre, List<index>>>
        .sortedByDescending { it.second.sumBy { plays[it] } }
        .map { it.second.sortedByDescending { plays[it] }.take(2) }
        .flatten()
        .toIntArray()
}