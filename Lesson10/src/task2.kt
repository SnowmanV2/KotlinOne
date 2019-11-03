fun main() {
    val names = ArrayList<String>()
    names.add("Крош")
    names.add("Ежик")
    names.add("Нюша")
    names.add("Бараш")
    val set = HashSet<String>()
    set.add("Крош")
    set.add("Ежик")
    set.add("Нюша")
    set.add("Бараш")
    names.forEach { print("$it ")}
    println()
    set.forEach { print("$it ")}
}

