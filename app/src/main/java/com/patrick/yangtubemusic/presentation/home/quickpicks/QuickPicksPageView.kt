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

    var musicCompact1: MusicCompact? = null
        set(value) {
            field = value
            binding.quickPicksItem1.musicData = musicCompact1
            invalidate()
            requestLayout()
        }
    var musicCompact2: MusicCompact? = null
        set(value) {
            field = value
            binding.quickPicksItem2.musicData = musicCompact2
            invalidate()
            requestLayout()
        }
    var musicCompact3: MusicCompact? = null
        set(value) {
            field = value
            binding.quickPicksItem3.musicData = musicCompact3
            invalidate()
            requestLayout()
        }
    var musicCompact4: MusicCompact? = null
        set(value) {
            field = value
            binding.quickPicksItem4.musicData = musicCompact4
            invalidate()
            requestLayout()
        }

    init {

    }
}