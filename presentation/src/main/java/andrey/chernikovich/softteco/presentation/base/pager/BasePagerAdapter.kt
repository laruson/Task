package andrey.chernikovich.softteco.presentation.base.pager

import andrey.chernikovich.domain.constants.POSTS_LIMIT_PER_PAGE
import android.databinding.ViewDataBinding
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject

abstract class BasePagerAdapter<
        Entity,
        VM : BasePagerViewModel<Entity>,
        B : ViewDataBinding>
    (val itemList: MutableList<Entity> = mutableListOf()) : PagerAdapter() {

    val clickItemSubject = PublishSubject.create<ItemClick<Entity>>()

    abstract fun provideBinding(viewGroup: ViewGroup): B

    abstract fun provideViewModel(): VM

    override fun isViewFromObject(view: View, `object`: Any)
            : Boolean = view == `object`

    override fun getCount()
            : Int = Math.ceil(itemList.size / POSTS_LIMIT_PER_PAGE.toDouble()).toInt()

    fun setItems(items: List<Entity>) {
        cleanItems()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    fun cleanItems() {
        itemList.clear()
        notifyDataSetChanged()
    }
}