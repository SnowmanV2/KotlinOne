package ru.tinkoff.animals.task8

const val MALE: Int = 1
const val FEMALE: Int = 0

abstract class Pet(val name: String,val sex: Int, var age: Int) {
    var isHere = true
    var isHungry = true
    var isFull = false
    var isCleaned = true
    fun eat() { // Питомец кушает
        println("$name поел${ if (sex == FEMALE) "a" else ""}")
        when {
            isHungry -> { // Если питомец голоден - он не голоден
                isHungry = false
                println("$name больше не голод${if (sex == FEMALE) "на" else "ен"}")
            }
            isFull -> runAway() // Если питомец уже сыт - он убегает
            else -> { // Если питомец не был голоден - он наедается
                isFull = true
                println("$name наел${if (sex == FEMALE) "ась" else "ся"}" )
            }
        }
    }
    fun runAway() {
        println("$name убежал${ if (sex == FEMALE) "a" else ""}, нагадив в угол напоследок. Вы - отвратильный хозяин")
        isHere = false
    }

}
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
class Dog(name: String, sex: Int, age: Int) :
        Pet(name, sex, age),
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
class Cat(name: String, sex: Int, age: Int) :
        Pet(name, sex, age),
        Walkable,
        Voiceable {
    override fun walk() {
        println("Иду гулять сам по себе")
    }
    override fun voice() {
        println("Мяу")
    }
}
class Parrot(name: String, sex: Int, age: Int) :
        Pet(name, sex, age),
        Flyable,
        Voiceable {
    override fun fly() {
        println("Я лечу-у-у, хэ-хэ-эй!")
    }
    override fun voice() {
        println("Здравствуй, товарищ.")
    }
}
class Snake(name: String, sex: Int, age: Int) :
        Pet(name, sex, age),
        Crawlable {
    override fun crawl() {
        println("Пополз${ if (sex == FEMALE) "ла" else "" }")
    }
}
class Fish(name: String, sex: Int, age: Int) :
        Pet(name, sex, age),
        Swimable,
        Voiceable {
    override fun swim() {
        println("Плыву")
    }

    override fun voice() {
        println("...")
    }
}


