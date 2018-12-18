package andrey.chernikovich.softteco.presentation.screen.main.adapter

import andrey.chernikovich.domain.entity.Post
import andrey.chernikovich.softteco.BR
import andrey.chernikovich.softteco.app.App
import andrey.chernikovich.softteco.databinding.ItemTwoLineBinding
import andrey.chernikovich.softteco.presentation.base.pager.BasePagerAdapter
import andrey.chernikovich.softteco.presentation.base.pager.ItemClick
import andrey.chernikovich.softteco.presentation.utils.cretePostsList
import andrey.chernikovich.softteco.presentation.utils.custom.DoubleTextView
import andrey.chernikovich.softteco.presentation.utils.postsInPositionList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PostPagerAdapter : BasePagerAdapter<Post,
        PostViewModel,
        ItemTwoLineBinding>() {

    override fun provideViewModel(): PostViewModel = PostViewModel()

    override fun provideBinding(viewGroup: ViewGroup)
            : ItemTwoLineBinding = ItemTwoLineBinding
        .inflate(
            LayoutInflater
                .from(App.instance), viewGroup, false
        )

    override fun instantiateItem(viewGroup: ViewGroup, position: Int): Any {
        cretePostsList(itemList)
        val binding = provideBinding(viewGroup)
        val viewModel = provideViewModel()
        binding.setVariable(BR.viewModel, viewModel)

        val pagePost = postsInPositionList[position]

        for (i in 0 until pagePost.size) {
            when (i) {
                0 -> setViewContent(binding.postOne, pagePost[i], position)
                1 -> setViewContent(binding.postTwo, pagePost[i], position)
                2 -> setViewContent(binding.postThree, pagePost[i], position)
                3 -> setViewContent(binding.postFour, pagePost[i], position)
                4 -> setViewContent(binding.postFive, pagePost[i], position)
                5 -> setViewContent(binding.postSix, pagePost[i], position)
            }
        }
        viewGroup.addView(binding.root)
        return binding.root
    }

    private fun setViewContent(doubleTextView: DoubleTextView, post: Post, position: Int) {
        setText(doubleTextView, post)
        setClick(doubleTextView, post, position)
    }

    private fun setText(doubleTextView: DoubleTextView, post: Post) {
        doubleTextView.setTextId(post.id.toString())
        doubleTextView.setTextTitle(post.title)
        doubleTextView.visibility = View.VISIBLE
    }

    private fun setClick(doubleTextView: DoubleTextView, post: Post, position: Int) {
        doubleTextView.setOnClickListener {
            clickItemSubject.onNext(ItemClick(post, position))
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}