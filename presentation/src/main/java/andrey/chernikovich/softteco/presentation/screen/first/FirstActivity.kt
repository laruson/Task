package andrey.chernikovich.softteco.presentation.screen.first

import andrey.chernikovich.softteco.R
import andrey.chernikovich.softteco.databinding.ActivityFirstBinding
import andrey.chernikovich.softteco.presentation.base.BaseMvvmActivity
import andrey.chernikovich.softteco.presentation.screen.first.adapter.PostPagerAdapter
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

class FirstActivity : BaseMvvmActivity <
        FirstViewModel,
        FirstRouter,
        ActivityFirstBinding>(){

    override fun provideViewModel()
            : FirstViewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)

    override fun provideRouter()
            : FirstRouter = FirstRouter(this)

    override fun provideLayoutId()
            : Int = R.layout.activity_first

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tab = binding.tab
        val viewPager = binding.viewPager

        viewPager.adapter = viewModel.adapter
        tab.setViewPager(viewPager)
        viewModel.adapter.registerDataSetObserver(tab.dataSetObserver)
    }
}