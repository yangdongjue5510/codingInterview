import java.util.*

fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Task>{one, other -> other.score.compareTo(one.score)}
    val hasDate: Array<Boolean> = Array(1001) { false }
    for (i in 0 until n) {
        val (dateString, scoreString) = readln().split(' ')
        queue.offer(Task(dateString.toInt(), scoreString.toInt()))
    }
    var sum = 0;
    while (!queue.isEmpty()) {
        sum += queue.poll().getScoreIfCanExecute(hasDate)
    }
    println(sum)
}

fun Task.findBestDate(hasDate: Array<Boolean>): Int {
    for (i in date downTo 1) {
        if (!hasDate[i]) {
            return i
        }
    }
    return -1
}

fun Task.getScoreIfCanExecute(hasDate: Array<Boolean>): Int = if (findBestDate(hasDate) != -1) {
    hasDate[findBestDate(hasDate)] = true
    score
} else 0

class Task(val date: Int, val score: Int)
