package codeforces.round886

class A {
    fun solve() {
        val a = readln().split(' ').map { it.toInt() }.sorted()
        println(if (a[1] + a[2] >= 10) "YES" else "NO")
    }
}

fun main() {
    var tt = readln().toInt()
    val solver = A()
    while (tt-- > 0) {
        solver.solve()
    }
}