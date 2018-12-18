package andrey.chernikovich.softteco.presentation.screen.contact

import andrey.chernikovich.softteco.R
import andrey.chernikovich.softteco.databinding.ActivityContactBinding
import andrey.chernikovich.softteco.presentation.base.BaseMvvmActivity
import andrey.chernikovich.domain.constants.EXTRA_POST_ID
import andrey.chernikovich.domain.constants.EXTRA_USER_ID
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : BaseMvvmActivity<
        ContactViewModel,
        ContactRouter,
        ActivityContactBinding>() {

    private lateinit var routerIntent : Intent

    override fun provideViewModel()
            : ContactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

    override fun provideRouter()
            : ContactRouter = ContactRouter(this)

    override fun provideLayoutId()
            : Int = R.layout.activity_contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId= intent.getIntExtra(EXTRA_USER_ID,0)
        val postId = intent.getIntExtra(EXTRA_POST_ID, 0)
        supportActionBar!!.title = "Contact #$userId"
        viewModel.setUser(userId)
        viewModel.post.set(postId)

        textViewEmail.setOnClickListener {
            routerIntent = Intent(Intent.ACTION_SENDTO,
                Uri.parse("mailto:" + viewModel.email.get()))
            startActivity(routerIntent)
        }

        textViewWeb.setOnClickListener {
            routerIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://" + viewModel.webSite.get()))
            startActivity(routerIntent)
        }

        textViewPhone.setOnClickListener {
            routerIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("tel:" + viewModel.phone.get()))
            startActivity(routerIntent)
        }

        textViewCity.setOnClickListener {
            val intentUri = Uri.parse("http://maps.google.com/maps?q=loc:" +
                    "${viewModel.geo.get()!!.lat},${viewModel.geo.get()!!.lng}")
            routerIntent = Intent(Intent.ACTION_VIEW, intentUri)
            routerIntent.setPackage("com.google.android.apps.maps")
            startActivity(routerIntent)
        }
    }

    override fun onBackPressed() {
        router.showFirstActivity()
    }
}