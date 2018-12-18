package andrey.chernikovich.data.net.entity

data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : DataEntity