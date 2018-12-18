package andrey.chernikovich.softteco.presentation.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.TextView

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("android:text")
fun textInt(view: TextView, value: Int) {
    view.text = value.toString()
}