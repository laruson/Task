package andrey.chernikovich.softteco.presentation.screen.main

import andrey.chernikovich.domain.usecase.GetPostUseCase
import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.presentation.base.BaseViewModel
import andrey.chernikovich.softteco.presentation.screen.main.adapter.PostPagerAdapter
import javax.inject.Inject

class MainViewModel : BaseViewModel<MainRouter>() {
    @Inject
    lateinit var getPosts : GetPostUseCase

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
}