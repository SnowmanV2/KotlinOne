package ru.tinkoff.task6
enum class Sex {
    MALE, FEMALE
}
class Pet() {
    var nickname = ""
    var age: Int = 0
    var sex: Sex? = null
    override fun toString(): String {
        return "name = $nickname   age = $age   sex = $sex"
    }
}

fun main() {
    // apply и also - удобно для инициализации, потому что неявно вовзращают вызываемый объект
    val barsik = Pet().apply {
        this.nickname = "Барсик"
        this.age = 10
        this.sex = Sex.MALE
    }
    val gladiolus = Pet().also {
        it.nickname = "Гладиолус"
        it.age = 1
        it.sex = null
        it
    }
    // let и with - менее удобно для инициализации, т. к. требуется явно указать возвращаемое выражение
    val sailorManThePet = Pet().let {
        it.nickname = "Матроскин"
        it.age = 7
        it.sex = Sex.MALE
        it
    }
    val zinaidaSergeevna = with(Pet()) {
        this.nickname = "Зинаида Сергеевна"
        this.age = 6
        this.sex = Sex.FEMALE
        this
    }
    println(barsik)
    println(gladiolus)
    println(sailorManThePet)
    println(zinaidaSergeevna)
}