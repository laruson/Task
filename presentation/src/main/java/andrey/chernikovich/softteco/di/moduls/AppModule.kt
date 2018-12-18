package andrey.chernikovich.softteco.di.moduls

import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.executer.UIThread
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun providePostExecutorThread(): PostExecutorThread {
        return UIThread()
    }
}