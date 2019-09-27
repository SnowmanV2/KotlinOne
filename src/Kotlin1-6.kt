import java.util.*
import kotlin.random.Random

fun main()
{
    val scan = Scanner(System.`in`)
    println("Input array length:")
    val n = scan.nextInt()
    var exampleArr: IntArray = IntArray(n){Random.nextInt(1,100) }
    println("Initial array:")
    printArr(exampleArr)
    qSort(exampleArr,0,n-1)
    println("Sorted array:")
    printArr(exampleArr)
}
fun printArr(exampleArr: IntArray)
{
    for(arg in exampleArr)
        print("$arg ")
    println()
}

fun qSort(A: IntArray, low: Int, high: Int)
{
    //Точка отсчета - средний элемент массива
    val pIndex: Int = (low + high)/2
    val pVal = A[pIndex]
    var i = low
    var j = high
    //Сортировка относительно A[pIndex]
    do{
        while(A[i]<pVal)
            ++i
        while(A[j]>pVal)
            --j
        if(i<=j) {
            val buf = A[i]
            A[i] = A[j]
            A[j] = buf
            ++i
            --j
        }
    } while (i<j)
    //Вызов функции для массивов размера > 1
    if (low < j) qSort(A,low,j)
    if (high > i) qSort(A,i,high)
}
