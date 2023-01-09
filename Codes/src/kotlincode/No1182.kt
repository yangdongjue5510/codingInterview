var n: Int = 0
var s: Int = 0
var count: Int = 0
var numbers: Array<Int> = Array(0) { 0 }

fun main() {
    val nAndS = readln()
        .split("\\s".toRegex()).toTypedArray()
    n = nAndS[0].toInt()
    s = nAndS[1].toInt()
    numbers = Array(n) { 0 }
    val numberLetters = readln()
        .split("\\s".toRegex()).toTypedArray()
    for (i in 0 until n) {
        numbers[i] = numberLetters[i].toInt()
    }
    run(0, 0)
    println(count)
}

fun run(sum: Int, index: Int) {
    when {
        index >= n -> return
        sum + numbers[index] == s -> count ++
    }
    run(sum, index + 1)
    run(sum + numbers[index], index + 1)
}
