fun main()
{
    println("Input name:")
    val name = readLine()
    println("Input num1:")
    val num1 = parseInt(readLine())
    println("input num2:")
    val num2 = parseInt(readLine())
    println("$name получает $num1 через $num2 лет")
}
fun parseInt(s: String?): Int
{
    if(s == null) throw IllegalArgumentException("Input must be number")
    for(ch in s)
        if(ch !in '0'..'9') throw IllegalArgumentException("Input must be number")
    return s.toInt()
}