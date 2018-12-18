package andrey.chernikovich.softteco.di.moduls.repository

import andrey.chernikovich.data.db.dao.UserDao
import andrey.chernikovich.data.file.Reader
import andrey.chernikovich.data.file.Writer
import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.data.repository.IORepositoryImpl
import andrey.chernikovich.data.repository.PostRepositoryImpl
import andrey.chernikovich.data.repository.UserRepositoryImpl
import andrey.chernikovich.domain.repository.IORepository
import andrey.chernikovich.domain.repository.PostRepository
import andrey.chernikovich.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePostRepository(restService: RestService): PostRepository {
        return PostRepositoryImpl(restService)
    }

    @Provides
    fun provideUserRepository(restService: RestService, userDao: UserDao): UserRepository {
        return UserRepositoryImpl(restService, userDao)
    }

    @Provides
    fun provideIORepository(reader: Reader, writer: Writer): IORepository {
        return IORepositoryImpl(reader, writer)
    }
}