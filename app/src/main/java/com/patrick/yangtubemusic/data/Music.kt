package com.patrick.yangtubemusic.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val title: String,
    val artist: String,
    val thumbnailUrl: String,
    val likeStatus: Boolean? = null
): Parcelable