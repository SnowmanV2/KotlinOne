fun main() {
    val names = listOf("Хрюша", "Степаша", "Филя", "Гуля")
    if (names.any { it.length == 7} )
        println("Есть")
    else
        println("Нет")
}