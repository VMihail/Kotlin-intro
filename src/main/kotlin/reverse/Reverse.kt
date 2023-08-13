package reverse

fun main() {
    var nextLine: String?
    val matrix = ArrayList<ArrayList<Int>>()
    while (true) {
        nextLine = readlnOrNull()
        if (nextLine == null) {
            break
        } else if (nextLine.isEmpty()) {
            continue
        }
        matrix.add(nextLine.split("\\s+".toRegex()).map { it.toInt() } as ArrayList<Int>)
    }
    matrix.reversed().forEach { line ->
        line.forEach {
            print("$it ")
        }
        println()
    }
}