package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.user.User
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    private val userRepository: UserRepository
) : BaseUseCase(postExecutorThread) {

    fun getUser(id: Int): Observable<User> {
        return userRepository.getUser(id)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }

}