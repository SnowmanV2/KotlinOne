import java.util.*

val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    println("Input 4 numbers:")
    val a = scan.nextInt()
    val b = scan.nextInt()
    val c = scan.nextInt()
    val d = scan.nextInt()
    println(minOfFour(a,b,c,d))
}
fun minOfFour(a: Int, b : Int, c: Int, d: Int):Int{
    return min(min(a,b), min(c,d))
}
fun min(a: Int, b: Int) = if(a < b) a else b