fun main() {
    val names = listOf("Хрюша", "Степаша", "Филя", "Гуля")
    println(names.maxBy {it.length})
}