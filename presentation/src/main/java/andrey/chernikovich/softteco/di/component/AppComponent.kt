package andrey.chernikovich.softteco.di.component

import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.di.moduls.AppModule
import andrey.chernikovich.softteco.di.moduls.data.DaoModule
import andrey.chernikovich.softteco.di.moduls.data.DataModule
import andrey.chernikovich.softteco.di.moduls.data.RestServiceModule
import andrey.chernikovich.softteco.di.moduls.repository.RepositoryModule
import andrey.chernikovich.softteco.presentation.screen.main.MainViewModel
import andrey.chernikovich.softteco.presentation.screen.contact.ContactViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DaoModule::class,
        DataModule::class,
        RestServiceModule::class,
        RepositoryModule::class,
        AppModule::class]
)
interface AppComponent {
    fun inject(app: App)

    fun inject(viewModel:MainViewModel)

    fun inject(viewModel: ContactViewModel)
}