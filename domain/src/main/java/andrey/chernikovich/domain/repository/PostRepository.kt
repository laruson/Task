package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.Post
import io.reactivex.Observable

interface PostRepository {

    fun getPost():Observable<List<Post>>
}