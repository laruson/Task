package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Post
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PostRepository
import io.reactivex.Observable

class GetPostUseCase(
    postExecutorThread: PostExecutorThread,
    private val postRepository: PostRepository
) : BaseUseCase(postExecutorThread) {
    fun getPosts(): Observable<List<Post>> {
        return postRepository.getPost()
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}