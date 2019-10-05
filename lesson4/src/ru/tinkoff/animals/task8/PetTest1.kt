package ru.tinkoff.animals.task8

import org.junit.Test

import org.junit.Assert.*

class PetTest1 {
    private val testPet = Dog("testName",MALE,1)
    @Test
    fun eatHungry() {
        //Питомец был голодным, когда его покормили
        //Он должен перестать быть голодным
        testPet.eat()
        assertEquals(testPet.isHungry,false)
        assertEquals(testPet.isFull,false)
    }
    @Test
    fun eatNotHungry() {
        //Питомец не голоден и не сыт, когда его покормили (его покормили два раза)
        //Он должен стать сытым
        testPet.eat()
        testPet.eat()
        assertEquals(testPet.isFull,true)
        assertEquals(testPet.isHungry,false)
    }
    @Test
    fun eatFull() {
        //Питомец был сыт, когда его покормили (его покормили три раза)
        //Он должен убежать
        testPet.eat()
        testPet.eat()
        testPet.eat()
        assertEquals(testPet.isHere,false)
    }
    @Test
    fun endDayCheckNoEat() {
        //Питомца не кормили
        //Питомец должен убежать
        testPet.endDayCheck()
        assertEquals(testPet.isHere,false)
    }
    @Test
    fun endDayCheckEatOnce() {
        //Питомца покормили один раз
        //Питомец должен проголодаться
        testPet.eat()
        testPet.endDayCheck()
        assertEquals(testPet.isHungry,true)
        assertEquals(testPet.isFull,false)
    }
    @Test
    fun endDayCheckEatTwice() {
        //Питомца покормили два раза и не убрались
        //Питомец должен перестать быть сытым
        //За питомцем надо будет убраться
        testPet.eat()
        testPet.eat()
        testPet.endDayCheck()
        assertEquals(testPet.isHungry,false)
        assertEquals(testPet.isFull,false)
        assertEquals(testPet.isCleaned,false)
    }
    @Test
    fun endDayCheckDoNotClean() {
        //Питомца покормили два раза и за ним не убирались полный день
        //Он должен убежать
        testPet.eat()
        testPet.eat()
        testPet.endDayCheck()
        testPet.endDayCheck()
        assertEquals(testPet.isHere,false)
    }
    @Test
    fun endDayCheckClean() {
        //Питомца покормили два раза, но за ним убрались
        //Питомец не должен убежать
        testPet.eat()
        testPet.eat()
        testPet.endDayCheck()
        testPet.isCleaned = true
        assertEquals(testPet.isHere, true)
    }
}