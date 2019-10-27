package ru.tinkoff.task3

enum class Sex {
    MALE, FEMALE
}

open class Pet <out T> (
    var nickname: String,
    var age: Int,
    var sex: Sex
)

class Dog(nickname: String, age: Int, sex: Sex) : Pet<Dog>(nickname, age, sex)
class Cat(nickname: String, age: Int, sex: Sex) : Pet<Cat>(nickname, age, sex)

class Owner(val pet: Pet<Any>) {
    fun feed() {
        println("Домашнее животное ${pet.nickname} накормлено")
    }
}

fun main() {
    val owner = Owner(Pet("Barsik I", 2, Sex.MALE))
    val owner2 = Owner(Dog("Пёсель", 3, Sex.MALE))
    val owner3 = Owner(Cat("Barsik II", 3, Sex.FEMALE))
    owner.feed()
    owner2.feed()
    owner3.feed()
}

