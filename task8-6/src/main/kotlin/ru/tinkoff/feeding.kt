package ru.tinkoff

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val pet1 = Pet("Жучка", 1500)
    val pet2 = Pet("Волчок", 600)
    val pet3 = Pet("Барсик", 2000)
    val pet4 = Pet("Борис", 1000)
    val pet5 = Pet("Мухтар", 1500)
    // Первая часть
    println("Раздаю еду") // Задает время отсчета
    runBlocking {
        launch { pet1.eat() }
        launch { pet2.eat() }
        launch { pet3.eat() }
        launch { pet4.eat() }
        launch { pet5.eat() }
    }
    // Ожидаемое время - 2 секунды
    println("Животные накормлены")
    // Вторая часть:
    // Все животные снова голодные
    pet1.isFed = false
    pet2.isFed = false
    pet3.isFed = false
    pet4.isFed = false
    pet5.isFed = false
    println("Начинаю раздавать еду (снова)")
    GlobalScope.launch {
        launch { pet1.eat() }
        launch { pet2.eat() }
        launch { pet3.eat() }
        launch { pet4.eat() }
        launch { pet5.eat() }

    }
    println("Еду раздал")
    // Ждем, пока всех не накормят
    while (!pet1.isFed || !pet2.isFed || !pet3.isFed || !pet4.isFed || !pet5.isFed)
        Thread.sleep(10)

    println("Животные накормлены")
}