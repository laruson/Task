package andrey.chernikovich.softteco.presentation.screen.main

import andrey.chernikovich.softteco.R
import andrey.chernikovich.softteco.databinding.ActivityMainBinding
import andrey.chernikovich.softteco.presentation.base.BaseMvvmActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

class MainActivity : BaseMvvmActivity <
        MainViewModel,
        MainRouter,
        ActivityMainBinding>(){

    override fun provideViewModel()
            : MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    override fun provideRouter()
            : MainRouter = MainRouter(this)

    override fun provideLayoutId()
            : Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tab = binding.tab
        val viewPager = binding.viewPager

        viewPager.adapter = viewModel.adapter
        tab.setViewPager(viewPager)
        viewModel.adapter.registerDataSetObserver(tab.dataSetObserver)
    }
}