package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.IORepository
import javax.inject.Inject

class ReadLogsUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    private val ioRepository: IORepository
) : BaseUseCase(postExecutorThread) {
    fun readLogs(): String {
        return ioRepository.read()
    }
}