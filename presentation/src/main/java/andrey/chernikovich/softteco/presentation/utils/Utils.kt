package andrey.chernikovich.softteco.presentation.utils

import andrey.chernikovich.domain.constants.POSTS_LIMIT_PER_PAGE
import andrey.chernikovich.domain.entity.Post

val postsInPositionList = mutableListOf<List<Post>>()

fun cretePostsList(posts: List<Post>) {
    var position = 0
    val pageCount = Math.ceil(posts.size.toDouble() / POSTS_LIMIT_PER_PAGE).toInt()

    for (postPage in 1..pageCount) {
        val pageList = mutableListOf<Post>()
        for (i in 1..POSTS_LIMIT_PER_PAGE) {
            pageList.add(posts[position++])
            if (position >= posts.size)
                break
        }
        postsInPositionList.add(pageList)
    }
}