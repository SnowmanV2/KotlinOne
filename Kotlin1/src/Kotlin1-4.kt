import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val a = scan.nextInt()
    val b = scan.nextInt()
    print(mult(a,b))
}
fun mult(a: Int, b: Int): Long //Long гарантирует отсутствие переполнения переменной
{
    return a.toLong()*b.toLong()
}