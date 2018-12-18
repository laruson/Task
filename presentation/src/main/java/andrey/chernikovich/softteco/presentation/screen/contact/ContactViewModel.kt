package andrey.chernikovich.softteco.presentation.screen.contact

import andrey.chernikovich.domain.entity.user.Geo
import andrey.chernikovich.domain.usecase.GetUserUseCase
import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.presentation.base.BaseViewModel
import andrey.chernikovich.softteco.presentation.utils.EMPTY
import android.databinding.ObservableField
import android.databinding.ObservableInt
import javax.inject.Inject

class ContactViewModel : BaseViewModel<ContactRouter>() {
    val post = ObservableInt()
    val geo = ObservableField<Geo>()
    val name = ObservableField<String>(EMPTY)
    val nickName = ObservableField<String>(EMPTY)
    val email = ObservableField<String>(EMPTY)
    val webSite = ObservableField<String>(EMPTY)
    val phone = ObservableField<String>(EMPTY)
    val city = ObservableField<String>(EMPTY)

    @Inject
    lateinit var getUser: GetUserUseCase

    init {
        App.appComponent.inject(this)
    }

    fun setUser(userId: Int) {
        addToDisposable(getUser.getUser(userId).subscribe(
            {
                name.set(it.name)
                nickName.set(it.username)
                email.set(it.email)
                webSite.set(it.website)
                phone.set(it.phone)
                city.set(it.address.city)
                geo.set(it.address.geo)
            },
            {
                router?.showError(it)
            }
        ))
    }

    fun saveUser(){
        
    }
}