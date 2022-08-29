package com.patrick.yangtubemusic.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Content(

) {
    @Parcelize
    data class Music(
        val title: String,
        val artist: String,
        val thumbnailUrl: String,
        val likeStatus: Boolean? = null
    ): Parcelable, Content()

    @Parcelize
    data class Artist(
        val thumbnailUrl: String,
        val name: String,
        val description: String
    ): Parcelable, Content()

    @Parcelize
    data class Playlist (
        val name: String,
        val description: String,
        val thumbnailUrl: String,
        val playList: List<Music>
    ): Parcelable, Content()
}