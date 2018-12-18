package andrey.chernikovich.softteco.app

import andrey.chernikovich.softteco.di.component.AppComponent
import andrey.chernikovich.softteco.di.moduls.AppModule
import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    init {
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}