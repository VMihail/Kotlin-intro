package sum

fun main(args: Array<String>) {
    val inputLine = StringBuilder()
    for (arg in args) {
        inputLine.append(arg).append(" ")
    }
    var result = 0
    val currentNumber = StringBuilder()
    for (ch in inputLine) {
        if (ch.isWhitespace() && currentNumber.isNotEmpty()) {
            result += currentNumber.toString().toInt()
            currentNumber.setLength(0)
        } else {
            currentNumber.append(ch)
        }
    }
    if (currentNumber.isNotEmpty()) {
        result += currentNumber.toString().toInt()
    }
    println(result)
}