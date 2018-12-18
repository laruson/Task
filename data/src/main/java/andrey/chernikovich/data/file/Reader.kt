package andrey.chernikovich.data.file

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class Reader(private val inputStream: InputStream) {

    fun execute(): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val readString = StringBuilder()
        var line = reader.readLine()
        while (line != null) {
            readString.append(line).append("\n")
            line = reader.readLine()
        }
        return readString.toString()
    }
}