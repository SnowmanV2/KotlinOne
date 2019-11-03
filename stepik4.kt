
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val stackItems = ArrayDeque<Int>()
    val stackMax = ArrayDeque<Int>()
    val outputArr = mutableListOf<Int>()
    val commandsNumber = scan.nextInt()
    for (i in 0 until commandsNumber) {
        when (scan.next()) {
            "push" -> {
                val item = scan.nextInt()
                stackItems.push(item)
                if ((stackMax.isEmpty()) || (item > stackMax.peek()))
                    stackMax.push(item)
                else
                    stackMax.push(stackMax.peek())
            }
            "pop" -> {
                stackItems.pop()
                stackMax.pop()
            }
            "max" -> {
                outputArr.add(stackMax.peek())
            }
        }
    }
    outputArr.forEach {println(it)}
}
