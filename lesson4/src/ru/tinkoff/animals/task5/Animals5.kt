package ru.tinkoff.animals.task5


class Dog(val name: String, val age: Int)
class Cat(val name: String, val age: Int)
class Parrot(val name: String, val age: Int)
class Snake(val name: String, val age: Int)
class Fish(val name: String, val age: Int)

fun main(){
    val dog = Dog("Pes",7)
    val cat = Cat("Kot",8)
    val parrot = Parrot("Fedor",3)
    val snake = Snake("Raisa Petrovna",4)
    val fish = Fish("Murzik",1)
}
