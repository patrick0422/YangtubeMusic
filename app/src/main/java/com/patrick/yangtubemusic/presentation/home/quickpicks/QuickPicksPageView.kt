package com.patrick.yangtubemusic.presentation.home.quickpicks

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.patrick.yangtubemusic.databinding.PageQuickPicksBinding

class QuickPicksPageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: PageQuickPicksBinding by lazy {
        PageQuickPicksBinding.inflate(LayoutInflater.from(context), this, true)
    }
}