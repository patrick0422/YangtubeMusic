package com.patrick.yangtubemusic.presentation.common.player

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.motion.widget.MotionLayout
import coil.load
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.databinding.PlayerCollapsableBinding

class CollapsiblePlayer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : MotionLayout(context, attrs, defStyleAttr) {
    private val binding: PlayerCollapsableBinding =
        PlayerCollapsableBinding.inflate(LayoutInflater.from(context), this, true)

    fun setData(music: Content.Music) = with(binding) {
        imageThumbnail.load(music.thumbnailUrl)
        textTitle.text = music.title
        textSubtitle.text = music.artist

        minimizedTitle.text = music.title
        minimizedSubtitle.text = music.artist

        motionLayout.transitionToState(R.id.start)
    }
}