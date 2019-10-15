package ru.tinkoff.task1

enum class Sex {
    MALE, FEMALE
}

class Pet(
    var nickname: String,
    var age: Int,
    var sex: Sex
) {

    override fun toString(): String {
        return "name = $nickname   age = $age   sex = $sex"
    }
}

fun Pet.isAdult() = age >= 2
val Pet.respectableName: String
    get() {
        return "Dear ${this.nickname}"
    }

fun isAdultPrint(pet: Pet) {
    if (pet.isAdult())
        println("${pet.nickname} уже взрослый")
    else
        println("${pet.nickname} еще ребёнок")
}

fun main() {
    val somePet = Pet("Barsik", 2, Sex.MALE)
    isAdultPrint(somePet)
    println(somePet)
    println(somePet.respectableName)
    val somePet2 = Pet("Barsik", 1, Sex.MALE)
    isAdultPrint(somePet2)
}