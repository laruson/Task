package andrey.chernikovich.softteco.di.moduls.data

import andrey.chernikovich.data.db.database.UserDatabase
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideUserDatabase(context: Context): UserDatabase {
        return UserDatabase.getInstance(context)
    }

}