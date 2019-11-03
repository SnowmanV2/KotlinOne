package ru.tinkoff

import java.util.*

data class StackItem(val value: Char, val index: Int)

fun main() {
    val scan = Scanner(System.`in`)
    val bracketsTable = hashMapOf(')' to '(', ']' to '[', '}' to '{')
    val bracketsStack = ArrayDeque<StackItem>()
    var cnt = 0
    val inputS: String = scan.next()
    for (i in inputS.indices) {
        val ch: Char = inputS[i]
        if (ch.anyOf('(', '[', '{'))
            bracketsStack.push(StackItem(ch, i + 1))
        else
            if (ch.anyOf(')', ']', '}')) {
                if (bracketsStack.isEmpty()) {
                    return println(i + 1)
                } else {
                    if (bracketsStack.peek().value == bracketsTable[ch])
                        bracketsStack.pop()
                    else
                        return println(i + 1)
                }
            }
    }
    if (bracketsStack.isEmpty())
        println("Success")
    else
        println(bracketsStack.peek().index)
}

fun Char.anyOf(vararg items: Char): Boolean {
    for (item in items) {
        if (this == item)
            return true
    }
    return false
}