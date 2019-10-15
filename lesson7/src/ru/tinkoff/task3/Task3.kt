package ru.tinkoff.task3

enum class Sex {
    MALE, FEMALE
}

open class Pet(
    var nickname: String,
    var age: Int,
    var sex: Sex
) {
    open fun voice() {
        println("Голос!")
    }
}

class Dog(nickname: String, age: Int, sex: Sex) : Pet(nickname, age, sex) {
    override fun voice() {
        println("Гав-гав-гав")
    }
}

class Cat(nickname: String, age: Int, sex: Sex) : Pet(nickname, age, sex) {
    override fun voice() {
        println("Мяу.")
    }
}

class Owner<T>(val pet: T) {
    fun feed() {
        if (pet is Pet)
            println("Домашнее животное ${pet.nickname} накормлено")
        else
            println("Кого вы собираетесь кормить? $pet?")
    }
}

fun main() {
    val owner: Owner<Pet> = Owner(Pet("Barsik", 2, Sex.MALE))
    val owner2: Owner<Dog> = Owner(Dog("Пёсель", 3, Sex.MALE))
    val owner3: Owner<Int> = Owner(15)
    owner.feed()
    owner2.feed()
    owner3.feed()
}
