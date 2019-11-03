
import java.util.*

class QueOnStackMaxes {
    private val stackIn = Stack<Int>()
    private val stackOut = Stack<Int>()
    private val stackInMaxes = Stack<Int>()
    private val stackOutMaxes = Stack<Int>()
    fun push(item: Int) {
        stackIn.push(item)
        if ((stackInMaxes.isEmpty()) || (item > stackInMaxes.peek()))
            stackInMaxes.push(item)
        else
            stackInMaxes.push(stackInMaxes.peek())
    }
    fun front(): Int {
        if (stackOut.isEmpty())
            rotate()
        return stackOut.peek()
    }
    fun popFront() {
        if (stackOut.isEmpty())
            rotate()
        stackOut.pop()
        stackOutMaxes.pop()
    }
    fun max(): Int {
        return when {
            stackOutMaxes.isEmpty() -> stackInMaxes.peek()
            stackInMaxes.isEmpty() -> stackOutMaxes.peek()
            stackInMaxes.peek() > stackOutMaxes.peek() -> stackInMaxes.peek()
            else -> stackOutMaxes.peek()
        }
    }
    private fun rotate() {
        while (!stackIn.isEmpty()) {
            val item = stackIn.pop()
            stackOut.push(item)
            stackInMaxes.pop()
            if ((stackOutMaxes.isEmpty()) || (item > stackOutMaxes.peek()))
                stackOutMaxes.push(item)
            else
                stackOutMaxes.push(stackOutMaxes.peek())
        }
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val arrSize = scan.nextInt()
    val arr = mutableListOf<Int>()
    for (i in 0 until arrSize)
        arr.add(scan.nextInt())
    val windowSize = scan.nextInt()
    val stack = QueOnStackMaxes()
    for (i in 0 until windowSize - 1)
        stack.push(arr[i])
    for (i in windowSize - 1 until arrSize) {
        stack.push(arr[i])
        print("${stack.max()} ")
        stack.popFront()
    }
}

