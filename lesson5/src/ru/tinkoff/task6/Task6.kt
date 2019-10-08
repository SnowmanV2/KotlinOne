package ru.tinkoff.task6

data class Person(
    val firstName: String, // Имя
    val lastName: String, // Фамилия
    val age: Int, // Возраст
    val postIndex: String, // Индекс
    val phoneNumber: String // Номер телефона
)

fun compare(obj1: Any, obj2: Any): String {
    return if (obj1.equals(obj2))
                "$obj1 идентичен $obj2"
            else
                "$obj1 не идентичен $obj2"
}

fun main() {
    val personDmitry = Person("Дмитрий", "Попков", 19, "390039", "89534561234")
    val personDmitry2 = personDmitry.copy()
    val personDmitry3 = personDmitry.copy(phoneNumber = "89209514532")
    val personSergey = Person("Сергей", "Сафронов", 33,"390025","89517894572")
    println(compare(personDmitry,personDmitry2))
    println(compare(personDmitry,personDmitry3))
    println(compare(personDmitry,personSergey))
}