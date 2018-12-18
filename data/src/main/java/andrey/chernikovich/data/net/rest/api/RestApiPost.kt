package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.PostResponse
import andrey.chernikovich.data.net.entity.user.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApiPost {
    @GET("/posts")
    fun getPosts():Observable<List<PostResponse>>

    @GET("/users/{id}")
    fun getUser(@Path("id") id:Int) : Observable<UserResponse>
}