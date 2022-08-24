package com.patrick.yangtubemusic.presentation.home.quickpicks

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.databinding.ItemQuickPicksBinding

class QuickPicksItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ItemQuickPicksBinding by lazy {
        ItemQuickPicksBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var musicData: MusicCompact? = null
        set(value) {
            field = value
            musicData?.apply {
                binding.imageMusicThumbnail.load(thumbnailUrl)
                binding.textMusicTitle.text = title
                binding.textMusicArtist.text = artist
            }
        }
}