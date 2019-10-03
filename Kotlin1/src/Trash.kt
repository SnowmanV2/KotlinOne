abstract class Person(var name: String)
{
    abstract fun printInfo()
}
class Employee(name: String, var age: Int) : Person(name)
{
    override fun printInfo(){
        println("$name $age")
    }
}
fun main()
{
    val employee = Employee("lul", 45)


}