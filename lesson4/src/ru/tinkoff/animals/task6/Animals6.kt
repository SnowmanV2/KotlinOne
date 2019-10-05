package ru.tinkoff.animals.task6

interface Flyable {
    fun fly()
}
interface Walkable {
    fun walk()
}
interface Swimable {
    fun swim()
}
interface Crawlable {
    fun crawl()
}
interface Voiceable {
    fun voice()
}
class Dog(val name: String, val age: Int) :
        Walkable,
        Swimable,
        Voiceable {

    override fun walk() {
        println("Иду гулять")

    }
    override fun swim() {
        println("Я собака и я плаваю, ага")
    }
    override fun voice() {
        println("Гав.")
    }
}
class Cat(val name: String, val age: Int) :
        Walkable,
        Voiceable {
    override fun walk() {
        println("Иду гулять сам по себе")
    }
    override fun voice() {
        println("Мяу")
    }
}
class Parrot(val name: String, val age: Int) :
        Flyable,
        Voiceable {
    override fun fly() {
        println("Я лечу-у-у, хэ-хэ-эй!")
    }
    override fun voice() {
        println("Здравствуй, товарищ.")
    }
}
class Snake(val name: String, val age: Int) :
        Crawlable {
    override fun crawl() {
        println("Поползла")
    }
}
class Fish(val name: String, val age: Int) :
        Swimable,
        Voiceable {
    override fun swim() {
        println("Плыву")
    }

    override fun voice() {
        println("...")
    }
}

fun main(){
    val dog = Dog("Pes", 7)
    val cat = Cat("Kot", 8)
    val parrot = Parrot("Fedor", 3)
    val snake = Snake("Raisa Petrovna", 4)
    val fish = Fish("Murzik", 1)
}
