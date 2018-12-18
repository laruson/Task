package andrey.chernikovich.softteco.presentation.screen.main

import andrey.chernikovich.domain.usecase.GetPostUseCase
import andrey.chernikovich.domain.usecase.ReadLogsUseCase
import andrey.chernikovich.domain.usecase.WriteLogsUseCase
import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.presentation.base.BaseViewModel
import andrey.chernikovich.softteco.presentation.screen.main.adapter.PostPagerAdapter
import android.databinding.ObservableBoolean
import android.view.View
import javax.inject.Inject

class MainViewModel : BaseViewModel<MainRouter>() {

    val showButton = ObservableBoolean(false)

    @Inject
    lateinit var getPosts: GetPostUseCase
    @Inject
    lateinit var writeLogs: WriteLogsUseCase
    @Inject
    lateinit var readLogs: ReadLogsUseCase

    val adapter = PostPagerAdapter()

    init {
        App.appComponent.inject(this)
        addToDisposable(adapter.clickItemSubject.subscribe(
            {
                router?.showSecondActivity(it.item.id, it.item.userId)
            },
            {
                router?.showError(it)
            }
        ))

        addToDisposable(getPosts.getPosts().subscribe(
            {
                adapter.setItems(it)
            },
            {
                router?.showError(it)
            }
        ))
    }

    fun saveLogs(view: View) {
        writeLogs.writeLogs(readLogs.readLogs())
    }
}