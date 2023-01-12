package kotlincode

fun main() {
    val wordCheck: Array<Boolean>
    val words = ArrayList<String>()

    val target = readln()
    wordCheck = Array(target.length + 1) { false }
    wordCheck[target.length] = true
    for (i in 0 until readln().toInt()) {
        words.add(readln())
    }

    fun check(index: Int) {
        val substring = target.substring(index)
        for (word in words) {
            when {
                substring.length < word.length -> continue
                substring.startsWith(word) && wordCheck[index + word.length] -> {
                    wordCheck[index] = true
                    return
                }
            }
        }
    }
    for (i in target.length -1 downTo  0) {
        check(i)
    }
    println(if (wordCheck[0]) 1 else 0)
}
