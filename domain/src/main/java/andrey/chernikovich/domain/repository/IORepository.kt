package andrey.chernikovich.domain.repository

interface IORepository {
    fun read():String

    fun write(value:String)
}