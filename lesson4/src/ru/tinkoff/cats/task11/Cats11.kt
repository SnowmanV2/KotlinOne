package ru.tinkoff.cats.task11

open class Cat {
    open fun hunt () {
        println("Я охочусь на мышей, ведь я кот!")
    }
}

class HomeCat() : Cat() {
     fun hunt(isHunting: Boolean) {
        if (isHunting)
            super.hunt()
        else
            println("Ты че сдурел? Какие мыши? Иди корми меня, ленивая задница!")
    }
}

fun main() {
    val homeCat = HomeCat()
    homeCat.hunt(true)
    homeCat.hunt(false)
}