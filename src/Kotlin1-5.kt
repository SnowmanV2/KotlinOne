import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val s = scan.next()
    print(isCapitalized(s))
}
fun isCapitalized(s: String): Boolean
{
    return s[0].isUpperCase()
}