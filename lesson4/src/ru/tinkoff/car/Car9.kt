package ru.tinkoff.car
import java.util.Scanner

class Car() {
    fun ride(km: Int) {
        var kmLeft = km
        println("Поехали!")
        while (kmLeft > 0)
            println("Остал" +
                    "${if ((kmLeft % 10 == 1 ) && (kmLeft % 100 != 11)) "ся" else "ось"} " +
                    kmLeft +
                    " километр" +
                    makePlural(kmLeft--)
            )
        println("Приехали!")
    }
    private fun makePlural(amount: Int) : String {
        if ((amount % 100 >= 11) && (amount % 100 <= 20)) return "ов"
        return when (amount % 10) {
            1 ->  ""
            2,3,4 -> "а"
            else -> "ов"
        }
    }
}
val scan = Scanner(System.`in`)
fun main(args: Array<String>) {

    val car = Car()
    car.ride(scan.nextInt())
}