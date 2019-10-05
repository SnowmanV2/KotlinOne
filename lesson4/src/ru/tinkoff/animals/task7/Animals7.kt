package ru.tinkoff.animals.task7

const val MALE: Byte = 1
const val FEMALE: Byte = 0
//У всех питомцев - имя, пол, возраст.
//Все питомцы могут есть и убегать. Пока всё.
abstract class Pet(val name: String,val sex: Byte, var age: Int) {
    fun eat() {
        println("$name поел${ if (sex == FEMALE) "a" else ""}")
    }
    fun runAway() {
        println("$name убежал${ if (sex == FEMALE) "a" else ""}, нагадив в угол напоследок. Вы - отвратильный хозяин")
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
class Dog(name: String, sex: Byte, age: Int) :
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
class Cat(name: String, sex: Byte, age: Int) :
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
class Parrot(name: String, sex: Byte, age: Int) :
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
class Snake(name: String, sex: Byte, age: Int) :
        Pet(name, sex, age),
        Crawlable {
    override fun crawl() {
        println("Пополз${ if (sex == FEMALE) "ла" else "" }")
    }
}
class Fish(name: String, sex: Byte, age: Int) :
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

fun main(){
    val dog = Dog("Pes", MALE, 7)
    val cat = Cat("Kot", MALE, 8)
    val parrot = Parrot("Fedor", MALE, 3)
    val snake = Snake("Raisa Petrovna", FEMALE, 4)
    val fish = Fish("Murzik", MALE, 1)
}
