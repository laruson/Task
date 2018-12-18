package andrey.chernikovich.softteco.presentation.screen.contact

import andrey.chernikovich.softteco.presentation.base.BaseRouter
import andrey.chernikovich.softteco.presentation.screen.main.MainActivity
import android.content.Intent

class ContactRouter(activity: ContactActivity) : BaseRouter<ContactActivity>(activity) {

    fun showFirstActivity(){
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}