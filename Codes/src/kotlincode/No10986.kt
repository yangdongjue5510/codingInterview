fun main() {
    val line = readln()
        .split("\\s".toRegex()).toTypedArray()
    val n = line[0].toInt()
    val m = line[1].toInt()
    val remainderCounts = Array(m) { 0 }

    var sum = 0
    for (token in readln().split("\\s".toRegex()).toTypedArray()) {
        sum += token.toInt()
        sum %= m
        remainderCounts[sum]++
    }
    val result = remainderCounts.sumOf { it.toLong() * (it - 1) / 2 }
    println(result + remainderCounts[0])
}
