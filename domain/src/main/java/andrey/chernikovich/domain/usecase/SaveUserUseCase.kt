package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.user.User
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    private val userRepository: UserRepository
) : BaseUseCase(postExecutorThread) {
    fun saveUser(user: User) {
        userRepository.saveUser(user)
    }
}