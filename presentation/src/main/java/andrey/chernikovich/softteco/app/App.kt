package andrey.chernikovich.softteco.app

import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App
    }
    init {
        instance = this
    }
}