package com.patrick.yangtubemusic.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    val title: String,
    val artist: String,
    val thumbnailUrl: String
): Parcelable