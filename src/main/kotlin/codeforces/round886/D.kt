package codeforces.round886

class D {
    fun solve() {
        val (n, k) = readln().split(' ').map { it.toInt() }
        val a = readln().split(' ').map { it.toInt() }.sorted()
        var count = 1
        var result = 1
        for (i in 0 until n - 1) {
            if (a[i + 1] - a[i] > k) {
                count = 1
            } else {
                ++count
            }
            result = result.coerceAtLeast(count)
        }
        println(n - result)
    }
}

fun main() {
    val tt = readln().toInt()
    val solver = D()
    repeat(tt) { solver.solve() }
}