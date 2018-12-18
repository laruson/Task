package andrey.chernikovich.data.file

import android.content.Context
import android.util.Log
import java.io.BufferedWriter
import java.io.FileWriter

class Writer(private val context: Context, private val fileName: String) {

    fun execute(logs: String) {
        val writer = BufferedWriter(FileWriter("${context.applicationContext.cacheDir}/$fileName"))
        writer.use {
            Log.e("AA", logs)
            it.write(logs)
            it.flush()
        }
    }
}