
import java.util.*
class Pack (val arrival: Int, val duration: Int) {
    var finishTime: Int = duration
    var failedAfter: Int = 0
}
fun main() {
    val scan = Scanner(System.`in`)
    val queSize = scan.nextInt()
    val inputSize = scan.nextInt()
    val queue = ArrayDeque<Pack>()
    for (i in 0 until inputSize) {
        val nextArrival = scan.nextInt()
        val nextTime = scan.nextInt()
        if (queue.size < queSize) {
            val newPack = Pack(nextArrival, nextTime)
            if (!queue.isEmpty()) {
                if(queue.peekLast().finishTime > nextArrival)
                    newPack.finishTime += queue.peekLast().finishTime
                else
                    newPack.finishTime += nextArrival
            } else
                newPack.finishTime += nextArrival
            queue.addLast(newPack)
        } else {
            if (nextArrival < queue.peekFirst().finishTime)
                queue.peekLast().failedAfter++
            else {
                val front = queue.removeFirst()
                println(front.finishTime - front.duration)
                while (front.failedAfter != 0) {
                    println(-1)
                    --front.failedAfter
                }
                val newPack = Pack(nextArrival, nextTime)
                if (!queue.isEmpty()) {
                    if(queue.peekLast().finishTime > nextArrival)
                        newPack.finishTime += queue.peekLast().finishTime
                    else
                        newPack.finishTime += nextArrival
                } else
                    newPack.finishTime += nextArrival
                queue.addLast(newPack)
            }
        }
    }
    while (!queue.isEmpty()) {
        val front = queue.removeFirst()
        println(front.finishTime - front.duration)
        while (front.failedAfter != 0) {
            println(-1)
            --front.failedAfter
        }
    }
}