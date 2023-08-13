package wspp

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    if (args.size != 2) {
        System.err.println("2 arguments expected: <input file name> <output file name>")
        return
    }
    val inputFileName = args[0]
    var currentNumber = 0
    val wordStat = LinkedHashMap<String, Pair<Int, MutableList<Int>>>()
    try {
        File(inputFileName).forEachLine {
            val line = it.filter {
                    ch -> ch.isLetter() || ch == '\'' || ch.category == CharCategory.DASH_PUNCTUATION || ch.isWhitespace()
            }.split("\\s+".toRegex()).map { word -> word.lowercase() }
            line.forEach { word ->
                ++currentNumber
                if (wordStat.containsKey(word)) {
                    wordStat[word]!!.second.add(currentNumber)
                    wordStat[word] = Pair(currentNumber, wordStat[word]!!.second)
                } else {
                    wordStat[word] = Pair(1, mutableListOf(currentNumber))
                }
            }
        }
    } catch (e: FileNotFoundException) {
        System.err.printf("Input file not found: %s", e.message)
    }
    val outputFileName = args[1]
    File(outputFileName).printWriter().use { out ->
        wordStat.forEach {
            out.println("${it.key} ${it.value.first} ${it.value.second.joinToString(" ")}")
        }
    }
}