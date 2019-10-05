package ru.tinkoff.animals.task8

import java.util.Scanner
val scan = Scanner(System.`in`)
var day = 1 // Текущий игровой день
class Owner(var pet: Pet) {
    private var actionPoints: Int = 3 //Максимум очков действия в день
    fun makeAction() {
        println("У вас есть свободное время. Чем займетесь?")
        println("1. Покормить питомца.")
        println("2. Убрать за питомцем.")
        println("3. Смотреть футбол.")
        var chosenAction = getInt()
        while (chosenAction !in 1..3){
            println("Введите число от 1 до 3")
            chosenAction = getInt()
        }
        when (chosenAction) {
            1 -> feed()
            2 -> clean()
            3 -> watchTV()
        }
    }
    private fun feed() {
        println("Вы покормили своего питомца.")
        pet.eat()
        --actionPoints
        pointsCheck()
    }
    private fun clean() {
        println("Вы убираете за своим питомцем.")
        pet.isCleaned = true
        --actionPoints
        pointsCheck()
    }
    private fun watchTV() {
        println("Почти весь день вы лежали на диване и смотрели футбол. Телевизор успешно заглушал крики вашего питомца.")
        actionPoints -= 2
        pointsCheck()
    }
    private fun pointsCheck() { // Хозяин идет спать, если actionPoints <= 0
        if (actionPoints <=0) {
            println("Вы чувствуете себя уставшим и идёте спать")
            sleep()
        }
    }
    private fun sleep() {
        actionPoints = 3
        passDay()
    }
    private fun passDay() {
        pet.endDayCheck()
        if (pet.isHere) { //Если питомец не убежал, начинается новый день
            ++day
            println("____________________________________________")
            println("Здравствуй, новый день!")
            if (pet.isHungry)
                println("Ваш питомец проголодался")
            if (!pet.isCleaned)
                println("Кажется, за вашим питомцем пора прибраться")
        }
    }

}
//Гарантирует чтение Int из сканнера
fun getInt() :Int {
    return if(scan.hasNextInt())
        scan.nextInt()
    else {
        println("Введите число")
        scan.next()
        getInt()
    }
}
//Создаёт питомца с клавитуры
fun createPet() : Pet {
    println("Выберите питомца:")
    println("1. Собака")
    println("2. Кот")
    println("3. Попугай")
    println("4. Змея")
    println("5. Рыбка")
    var chosenPet = getInt()
    while (chosenPet !in 1..5) {
        println("Выберите число от 1 до 5")
        chosenPet = getInt()
    }
    println("Выберите пол вашего питомца:")
    println("1. Мужской")
    println("2. Женский")
    var petSex = getInt()
    while(petSex !in 1..2) {
        println("Выберите число от 1 до 2")
        petSex = getInt()
    }
    petSex = if (petSex == 1)
        MALE
    else
        FEMALE
    println("Выберите имя вашего питомца: ")
    val petName = readLine()!!
    return when (chosenPet) {
        1 -> Dog(petName, petSex,1)
        2 -> Cat(petName, petSex, 1)
        3 -> Parrot(petName, petSex, 1)
        4 -> Snake(petName, petSex, 1)
        5 -> Fish(petName, petSex, 1)
        else -> Dog("ERROR",FEMALE,999)
    }
}
fun main() {
    var owner = Owner(createPet())
    //Единственный способ закончить игру - избавиться от питомца :(
    while (owner.pet.isHere) {
        owner.makeAction()
    }
    println("Игра окончена! Прошло $day дней")

}