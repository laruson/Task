package andrey.chernikovich.softteco.presentation.screen.first

import andrey.chernikovich.domain.usecase.GetPostUseCase
import andrey.chernikovich.softteco.presentation.base.BaseViewModel
import andrey.chernikovich.softteco.presentation.screen.first.adapter.PostPagerAdapter
import javax.inject.Inject

class FirstViewModel : BaseViewModel<FirstRouter>() {
    @Inject
    lateinit var getPosts : GetPostUseCase

    val adapter = PostPagerAdapter()

    init {
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