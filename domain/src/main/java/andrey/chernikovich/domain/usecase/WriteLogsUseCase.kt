package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.IORepository
import javax.inject.Inject

class WriteLogsUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    private val ioRepository: IORepository
) : BaseUseCase(postExecutorThread) {
    fun writeLogs(value: String) {
        ioRepository.write(value)
    }
}