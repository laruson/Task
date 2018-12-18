package andrey.chernikovich.softteco.di.moduls.data

import andrey.chernikovich.data.file.Reader
import andrey.chernikovich.data.file.Writer
import andrey.chernikovich.domain.constants.FILE_NAME
import andrey.chernikovich.domain.constants.LOG_FILE_NAME
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FileModule {

    @Provides
    fun provideReader(process: Process): Reader {
        return Reader(process.inputStream)
    }

    @Provides
    fun provideWriter(context: Context, @Named(FILE_NAME) fileName: String): Writer {
        return Writer(context, fileName)
    }

    @Provides
    @Singleton
    @Named(FILE_NAME)
    fun provideFileName(): String {
        return LOG_FILE_NAME
    }
}