import java.util.*

fun main()
{
    val scan = Scanner(System.`in`)
    println("Input number:")
    val n = scan.nextInt()
    println("Input string:")
    val s = scan.next()
    println("n = $n, s = $s")
    printNTimes(n,s)
}
fun printNTimes(n: Int, s: String)
{
    if(n<0)
        println("Number must be 0 and more")
    else
        for(i in 1..n)
            println(s)
}