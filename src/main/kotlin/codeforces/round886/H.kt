package codeforces.round886

class H {
    fun solve() {
        val n = readln().toInt()
        val points = Array(n) {
            val (x, y) = readln().split(' ').map { it.toInt() }
            Pair(x, y)
        }
        val row = mutableMapOf<Int, Int>()
        val col = mutableMapOf<Int, Int>()
        val firstDiag = mutableMapOf<Int, Int>()
        val secondDiag = mutableMapOf<Int, Int>()
        points.forEach { point ->
            row[point.second] = (row[point.second] ?: 0) + 1
            col[point.first] = (col[point.first] ?: 0) + 1
            firstDiag[point.first + point.second] = (firstDiag[point.first + point.second] ?: 0) + 1
            secondDiag[point.first - point.second] = (secondDiag[point.first - point.second] ?: 0) + 1
        }
        var result: Long = 0
        fun calc(map: MutableMap<Int, Int>) {
            map.forEach {
                result += it.value.toLong() * (it.value - 1)
            }
        }
        calc(row)
        calc(col)
        calc(firstDiag)
        calc(secondDiag)
        println(result)
    }
}

fun main() {
    val tt = readln().toInt()
    val solver = H()
    repeat(tt) { solver.solve() }
}