package ru.tinkoff

import kotlinx.coroutines.*

suspend fun main() {
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
    println("Начинаю раздавать еду (снова)")
    val areFed = GlobalScope.async {
        launch { pet1.eat() }
        launch { pet2.eat() }
        launch { pet3.eat() }
        launch { pet4.eat() }
        launch { pet5.eat() }
    }
    println("Еду раздал")
    areFed.await()
    println("Животные накормлены")
}