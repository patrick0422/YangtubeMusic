package com.patrick.yangtubemusic.data



sealed class Content<T>(
    val iconUrl: String? = null,
    val contentTitle: String,
    val contentDescription: String? = null,
    val content: T
) {
    class ListenAgain(
        contentTitle: String,
        content: List<Music>
    ): Content<List<Music>>(
        contentTitle = contentTitle,
        content = content
    )

    class MixedForYou(
        contentTitle: String,
        content: List<PlayList>
    ): Content<List<PlayList>>(
        contentTitle = contentTitle,
        content = content
    )

    class ContentRecommendationByArtist(
        thumbnailUrl: String,
        contentTitle: String,
        contentDescription: String,
        content: List<Artist>
    ): Content<List<Artist>>(
        iconUrl = thumbnailUrl,
        contentTitle = contentTitle,
        contentDescription = contentDescription,
        content = content
    )
}