fun main() {
    val names = listOf("Хрюша", "Степаша", "Филя", "Гуля")
    names
        .map { "Привет $it" }
        .forEach { println(it) }
}