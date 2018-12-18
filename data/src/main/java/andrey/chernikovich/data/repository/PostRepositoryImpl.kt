package andrey.chernikovich.data.repository

import andrey.chernikovich.data.net.entity.transformToPost
import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.domain.entity.Post
import andrey.chernikovich.domain.repository.PostRepository
import android.util.Log
import io.reactivex.Observable

class PostRepositoryImpl(private val restService: RestService) : PostRepository {

    override fun getPost(): Observable<List<Post>> {
        return restService.getPosts()
            .map { posts ->
            posts.map {
                it.transformToPost()
            }
        }
    }
}