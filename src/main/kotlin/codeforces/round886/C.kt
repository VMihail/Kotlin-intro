package codeforces.round886

class C {
    fun solve() {
        val row = 8
        val result = StringBuilder()
        for (i in 1..row) {
            val line = readln().filter { it.isLetter() }
            result.append(if (line.isNotEmpty()) line[0] else "")
        }
        println(result)
    }
}

fun main() {
    var tt = readln().toInt()
    val solver = C()
    while (tt-- > 0) {
        solver.solve()
    }
}