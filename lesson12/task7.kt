fun main() {
    val names = listOf("Хрюша", "Степаша", "Филя", "Гуля")
    names.asSequence()
        .filter { it.length <= 4 }
        .map { "Привет $it" }
        .forEach { println(it) }
}