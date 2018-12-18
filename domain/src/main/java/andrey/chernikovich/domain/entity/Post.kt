package andrey.chernikovich.domain.entity

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : DomainEntity