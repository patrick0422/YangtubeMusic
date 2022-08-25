package com.patrick.yangtubemusic.presentation.home.quickpicks

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.patrick.yangtubemusic.data.Music
import com.patrick.yangtubemusic.databinding.ItemQuickPicksBinding

class QuickPicksItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ItemQuickPicksBinding by lazy {
        ItemQuickPicksBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var musicData: Music? = null
        set(value) {
            field = value
            musicData?.apply {
                with(binding) {
                    imageMusicThumbnail.load(thumbnailUrl)
                    textMusicTitle.text = title
                    textMusicArtist.text = artist
                }
            }
        }

    fun setOnClickListener(onClick: (Music) -> Unit) {
        binding.layout.setOnClickListener {
            musicData?.let { musicData -> onClick(musicData) }
        }
    }

    fun setOnLongClickListener(onLongClick: (Music) -> Unit) {
        binding.layout.setOnLongClickListener {
            musicData?.let { musicData -> onLongClick(musicData) }
            true
        }
    }

    fun setOnMoreClickListener(onClick: (Music) -> Unit) {
        binding.buttonMore.setOnClickListener {
            musicData?.let { musicData -> onClick(musicData) }
        }
    }
}