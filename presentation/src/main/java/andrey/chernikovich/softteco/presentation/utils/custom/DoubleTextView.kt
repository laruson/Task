package andrey.chernikovich.softteco.presentation.utils.custom

import andrey.chernikovich.softteco.R
import android.content.Context
import android.opengl.Visibility
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.item_post.view.*


class DoubleTextView(context: Context, attributeSet: AttributeSet) : ConstraintLayout(context, attributeSet) {

    private val layout: ConstraintLayout

    init {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DoubleTextView)
        val textId = typedArray.getString(R.styleable.DoubleTextView_idText)
        val textTitle = typedArray.getString(R.styleable.DoubleTextView_titleText)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        layout = inflater.inflate(R.layout.item_post, this, true) as ConstraintLayout

        textViewId.text = textId
        textViewTitle.text = textTitle
        visibility = View.GONE

        typedArray.recycle()
    }

    fun setTextId(textId: String) {
        textViewId.text = textId
    }

    fun setTextTitle(textTitle: String) {
        textViewTitle.text = textTitle
    }
}