fun main() {
    val names = listOf("Крош", "Ежик", "Нюша", "Бараш")
    val set = setOf("Крош", "Ежик", "Нюша", "Бараш")
    val namesJava = ArrayList<String>()
    val setJava = HashSet<String>()
    names.forEach { namesJava.add(it) }
    set.forEach { setJava.add(it) }
    namesJava.forEach { print("$it ")}
    println()
    setJava.forEach { print("$it ")}
}