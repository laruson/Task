package andrey.chernikovich.softteco.presentation.screen.main

import andrey.chernikovich.softteco.R
import andrey.chernikovich.softteco.databinding.ActivityMainBinding
import andrey.chernikovich.softteco.presentation.base.BaseMvvmActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity<
        MainViewModel,
        MainRouter,
        ActivityMainBinding>() {
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

        startAnimation()
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.translate_animation)
        animation.duration = 5000
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                Log.d("Animation", "Start")
            }

            override fun onAnimationEnd(p0: Animation?) {
                Log.d("Animation", "End")
                viewModel.showButton.set(true)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        imageViewAnimation.startAnimation(animation)
    }
}