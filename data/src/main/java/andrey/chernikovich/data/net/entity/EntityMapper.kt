package andrey.chernikovich.data.net.entity

import andrey.chernikovich.domain.entity.Post

fun PostResponse.transformToPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}