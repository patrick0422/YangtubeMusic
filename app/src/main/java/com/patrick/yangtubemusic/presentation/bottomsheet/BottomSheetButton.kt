package com.patrick.yangtubemusic.presentation.bottomsheet

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.databinding.ButtonBottomSheetBinding

class BottomSheetButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ButtonBottomSheetBinding by lazy {
        ButtonBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)
    }

    @DrawableRes
    var icon: Int
    var description: String

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Common,
            0, 0).apply {

            try {
                icon = getResourceId(R.styleable.Common_icon, R.drawable.ic_question)
                description = getString(R.styleable.Common_description) ?: "Unknown"

                binding.imageIcon.setImageResource(icon)
                binding.textDescription.text = description
            } finally {
                recycle()
            }
        }
    }

    fun setOnClickListener(onClick: () -> Unit) {
        binding.layout.setOnClickListener { onClick() }
    }
}