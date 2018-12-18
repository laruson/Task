package andrey.chernikovich.softteco.di.moduls.data

import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.softteco.presentation.utils.JSON_URL
import andrey.chernikovich.softteco.presentation.utils.URL
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestServiceModule {
    @Provides
    @Singleton
    fun provideRestService(@Named(JSON_URL) url: String): RestService {
        return RestService(url)
    }

    @Provides
    @Singleton
    @Named(JSON_URL)
    fun provideUrl(): String {
        return URL
    }
}