package andrey.chernikovich.softteco.di.moduls.repository

import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.data.repository.PostRepositoryImpl
import andrey.chernikovich.data.repository.UserRepositoryImpl
import andrey.chernikovich.domain.repository.PostRepository
import andrey.chernikovich.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePostRepository(restService: RestService):PostRepository{
        return PostRepositoryImpl(restService)
    }

    @Provides
    fun provideUserRepository(restService: RestService):UserRepository{
        return UserRepositoryImpl(restService)
    }
}