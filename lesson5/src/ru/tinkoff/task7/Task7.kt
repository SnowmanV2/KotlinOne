package ru.tinkoff.task7

data class Person(
    val firstName: String, // Имя
    val lastName: String, // Фамилия
    val age: Int, // Возраст
    val postIndex: String, // Индекс
    val phoneNumber: String // Номер телефона
) {
    companion object PersonComparatorCompanion : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return if (o1.equals(o2)) {
                println("$o1 идентичен $o2")
                0
            } else {
                println("$o1 не идентичен $o2")
                -1
            }
        }
    }
}

object PersonComparatorSingleton : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int {
        return if (o1.equals(o2)) {
            println("$o1 идентичен $o2")
            0
        } else {
            println("$o1 не идентичен $o2")
            -1
        }
    }
    private fun isLess(o1:Person, o2: Person): Boolean {
        return o1.firstName < o2.firstName
    }
}


fun main() {
    val personDmitry = Person("Дмитрий", "Попков", 19, "390039", "89534561234")
    val personDmitry2 = personDmitry.copy()
    val personDmitry3 = personDmitry.copy(phoneNumber = "89209514532")
    val personSergey = Person("Сергей", "Сафронов", 33,"390025","89517894572")
    println("Проверка объекта-одиночки:")
    PersonComparatorSingleton.compare(personDmitry,personDmitry2)
    PersonComparatorSingleton.compare(personDmitry,personDmitry3)
    PersonComparatorSingleton.compare(personDmitry,personSergey)
    println("Проверка компаньона:")
    Person.compare(personDmitry,personDmitry2)
    Person.compare(personDmitry,personDmitry3)
    Person.compare(personDmitry,personSergey)
}