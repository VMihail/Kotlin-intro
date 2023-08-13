package codeforces.round886

class B {
    fun solve() {
        val n = readln().toInt()
        var quality = 0
        var id = 0
        for (i in 1..n) {
            val row = readln().split(' ').map { it.toInt() }
            if (row[0] <= 10 && row[1] > quality) {
                quality = row[1]
                id = i
            }
        }
        println(id)
    }
}

fun main() {
    var tt = readln().toInt()
    val solver = B()
    while (tt-- > 0) {
        solver.solve()
    }
}