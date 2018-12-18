package andrey.chernikovich.softteco.presentation.screen.main

import andrey.chernikovich.softteco.presentation.base.BaseRouter
import andrey.chernikovich.softteco.presentation.screen.contact.ContactActivity
import andrey.chernikovich.domain.constants.EXTRA_POST_ID
import andrey.chernikovich.domain.constants.EXTRA_USER_ID
import android.content.Intent

class MainRouter(activity: MainActivity) : BaseRouter<MainActivity>(activity) {

    fun showSecondActivity(postId:Int, userId:Int){
        val intent = Intent(activity, ContactActivity::class.java)

        intent.putExtra(EXTRA_POST_ID, postId)
        intent.putExtra(EXTRA_USER_ID, userId)

        activity.startActivity(intent)
        activity.finish()
    }
}