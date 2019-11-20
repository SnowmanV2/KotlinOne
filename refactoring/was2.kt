fun main() {
    val names = listOf("Хрюша", "Степаша", "Филя", "Гуля")
    var maxLength = names[0].length
    do {
        val maybeMaxLength = names.find { it.length > maxLength }?.length
        if (maybeMaxLength == null)
            return println(maxLength)
        else
            maxLength = maybeMaxLength
    } while (true)
}