import java.util.Scanner
fun main() {
    val scan = Scanner(System.`in`)
    val size = scan.nextInt()
    val arrR = mutableListOf<Int>() // Массив родителей
    val arrH = mutableListOf<Int>() // Массив высот
    var hMax = -1
    for (i in 0 until size) {
        arrR.add(scan.nextInt())
        arrH.add(-1)
    }
    for (i in 0 until size) {
        if ((arrH[i] == -1) && (arrR[i] != -1))
            arrH[i] = findH(arrR, arrH, 1, i)
        if (arrH[i] > hMax)
            hMax = arrH[i]
    }
    println(hMax)
}

fun findH(arrR: MutableList<Int>, arrH: MutableList<Int>, h: Int, i: Int): Int {
    return when {
        arrR[i] == -1 -> h
        arrH[i] != -1 -> (h + arrH[i] - 1)
        else -> findH(arrR, arrH, h +1, arrR[i])
    }
}