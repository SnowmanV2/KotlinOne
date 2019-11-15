package ru.tinkoff

import kotlinx.coroutines.delay

class Pet (private val nickName: String,
           private val mealDuration: Long) {
    suspend fun eat() {
        delay(mealDuration)
        println("$nickName поел!")
    }
}