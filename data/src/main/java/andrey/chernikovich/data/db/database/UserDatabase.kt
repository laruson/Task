package andrey.chernikovich.data.db.database

import andrey.chernikovich.data.db.dao.UserDao
import andrey.chernikovich.data.db.entity.Converter
import andrey.chernikovich.data.db.entity.UserDb
import andrey.chernikovich.domain.constants.DATABASE_NAME
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = [UserDb::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDatabase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): UserDatabase {
            return Room
                .databaseBuilder(context, UserDatabase::class.java, "Asd")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun userDao(): UserDao
}