package andrey.chernikovich.softteco.di.moduls.data

import andrey.chernikovich.data.db.dao.UserDao
import andrey.chernikovich.data.db.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }
}