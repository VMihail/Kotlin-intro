package wordStat

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    if (args.size != 2) {
        System.err.println("2 arguments expected: <input file name> <output file name>")
        return
    }
    val inputFileName = args[0]
    val wordStat = HashMap<String, Int>()
    try {
        File(inputFileName).forEachLine {
            val line = it.filter {
                ch -> ch.isLetter() || ch == '\'' || ch.category == CharCategory.DASH_PUNCTUATION || ch.isWhitespace()
            }.split("\\s+".toRegex()).map { word -> word.lowercase() }
            line.forEach { word ->
                if (wordStat.containsKey(word)) {
                    wordStat[word] = wordStat[word]!! + 1
                } else {
                    wordStat[word] = 1
                }
            }
        }
    } catch (e: FileNotFoundException) {
        System.err.println("input file not found: ${e.message}")
        return
    }
    val outputFileName = args[1]
    File(outputFileName).printWriter().use { out ->
        wordStat.forEach {
            out.println("${it.key} ${it.value}")
        }
    }
}