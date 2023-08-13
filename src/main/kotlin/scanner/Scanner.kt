package scanner

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringReader
import java.nio.file.Files
import java.nio.file.Path

class Scanner {
    private val reader: BufferedReader
    private var buffer: ArrayDeque<String>? = null

    constructor(str: String) {
        reader = BufferedReader(StringReader(str))
    }

    constructor(path: Path) {
        reader = Files.newBufferedReader(path)
    }

    constructor(inpStream: InputStream) {
        reader = BufferedReader(InputStreamReader(inpStream))
    }

    fun hasNext(): Boolean {
        read()
        return buffer?.isNotEmpty() ?: false
    }

    fun next(): String {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return buffer!!.removeFirst()
    }

    fun nextInt(): Int {
        return next().toInt()
    }

    fun nextLong(): Long {
        return next().toLong()
    }

    private fun read() {
        while (buffer == null || buffer!!.isEmpty()) {
            val nextLine: String = reader.readLine() ?: break
            if (buffer == null) {
                buffer = ArrayDeque()
            }
            buffer!!.addAll(nextLine.split("\\s+".toRegex()))
        }
    }
}