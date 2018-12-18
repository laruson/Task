package andrey.chernikovich.data.file

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class Reader(private val inputStream: InputStream) {

    fun execute(): String {
        val readString = StringBuilder()
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.use {
            var line = it.readLine()
            while (line != null) {
                readString.append(line).append("\n")
                line=reader.readLine()
            }
        }
        return readString.toString()
    }
}