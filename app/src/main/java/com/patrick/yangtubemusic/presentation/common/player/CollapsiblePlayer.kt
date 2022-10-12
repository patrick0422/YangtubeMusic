package com.patrick.yangtubemusic.presentation.common.player

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
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

        val bitmap: Bitmap = (imageThumbnail.drawable as BitmapDrawable).bitmap

        Palette.Builder(bitmap).generate {
            it?.let { palette ->
                val dominantColor = palette.getDominantColor(resources.getColor(R.color.almost_black, null))
                playerBackgroundView.setBackgroundColor(dominantColor)
            }
        }
    }
}