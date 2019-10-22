package ru.tinkoff

import kotlinx.coroutines.delay

class Pet (private val nickName: String,
           private val mealDuration: Long) {
    var isFed: Boolean = false
    suspend fun eat() {
        delay(mealDuration)
        println("$nickName поел!")
        isFed = true

    }
}