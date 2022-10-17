package com.patrick.yangtubemusic.presentation.common.player

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.graphics.ColorUtils
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.databinding.PlayerCollapsableBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        textTitle.isSelected = true
        textSubtitle.text = music.artist
        minimizedTitle.text = music.title
        minimizedSubtitle.text = music.artist

        motionLayout.transitionToState(R.id.start)

        CoroutineScope(Dispatchers.IO).launch {
            val loader = ImageLoader(context)
            val request = ImageRequest.Builder(context)
                .data(music.thumbnailUrl)
                .allowHardware(false) // Disable hardware bitmaps.
                .build()

            val result = (loader.execute(request) as SuccessResult).drawable
            val bitmap = (result as BitmapDrawable).bitmap

            Palette.from(bitmap).generate() { palette ->
                palette?.run {
                    val color = ColorUtils.blendARGB((vibrantSwatch?.rgb ?: R.color.almost_black), Color.BLACK, 0.2F)

                    playerBackgroundView.setBackgroundColor(color)
                }
            }
        }
    }
}