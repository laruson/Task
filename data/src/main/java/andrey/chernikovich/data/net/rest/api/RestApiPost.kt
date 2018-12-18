package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.PostResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApiPost {
    @GET("/posts")
    fun getPosts():Observable<List<PostResponse>>
}