package ru.tinkoff

// Исходный код:
/* fun main() {
    listOf("three", "two", "one").forEach {
        if(it == "one") {
            return
        }
        println(it)
    }
    println("boom!")
} */
// Проблема - forEach - inline функция, поэтому return выйдет из функции, и println("boom") не сработает
// Если бы forEach была бы не inline функцией, то return в принципе нельзя было бы использовать
// Решение - перенести лист и ф-ию forEach в отдельную функцию, а println("boom") выполнить в main():
fun countDown() {
    listOf("three", "two", "one").forEach {
        if (it == "one") {
            return
        }
        println(it)
    }
}
fun main() {
    countDown()
    println("boom!")
}

// Другое решение (однако, меняющее лямбду)
/* fun main() {
    listOf("three", "two", "one").forEach {
        if (it != "one")
            println(it)
    }
    println("boom!")
} */