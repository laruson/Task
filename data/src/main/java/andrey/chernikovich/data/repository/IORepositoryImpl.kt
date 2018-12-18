package andrey.chernikovich.data.repository

import andrey.chernikovich.data.file.Reader
import andrey.chernikovich.data.file.Writer
import andrey.chernikovich.domain.repository.IORepository

class IORepositoryImpl(private val reader: Reader,
                       private val writer:Writer) : IORepository {
    override fun read(): String {
        return reader.execute()
    }

    override fun write(value: String) {
        return writer.execute(value)
    }
}