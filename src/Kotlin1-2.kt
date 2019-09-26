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
    if (a<b)
        if(a < c)
            if(a<d)
                return a
            else
                return d
        else
            if(c<d)
                return c
            else
                return d
    else
        if(b<c)
            if(b < d)
                return b
            else
                return d
        else
            if(c<d)
                return c
            else
                return d

}
