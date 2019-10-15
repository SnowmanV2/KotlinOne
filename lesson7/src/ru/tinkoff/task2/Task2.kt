package ru.tinkoff.task2

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

// Поле расширения для Pet
val Pet.respectableName: String
    get() {
        return "Dear ${this.nickname}"
    }
// Поле расширения для Dog
val Dog.respectableName: String
    get() {
        return "Dear dog ${this.nickname}"
    }

fun main() {
    // somePet - Dog
    val somePet: Pet = Dog("Пёсель", 3, Sex.MALE)
    // Умение somePet лаять тому подтверждение
    somePet.voice()
    // А вызовется поле Pet!
    println(somePet.respectableName)
}