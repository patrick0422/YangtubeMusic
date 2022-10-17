package com.patrick.yangtubemusic.data



sealed class Contents(
    val iconUrl: String? = null,
    val contentTitle: String,
    val contentDescription: String? = null,
    val content: List<Content>
) {
    class ListenAgain(
        contentTitle: String = "다시 듣기",
        content: List<Content.Music>
    ): Contents(
        contentTitle = contentTitle,
        content = content
    )

    class MixedForYou(
        contentTitle: String = "맞춤 믹스",
        content: List<Content.Playlist>
    ): Contents(
        contentTitle = contentTitle,
        content = content
    )

    class ContentRecommendationByArtist(
        thumbnailUrl: String,
        contentTitle: String,
        contentDescription: String = "아래 아티스트를 좋아한다면",
        content: List<Content.Artist>
    ): Contents(
        iconUrl = thumbnailUrl,
        contentTitle = contentTitle,
        contentDescription = contentDescription,
        content = content
    )
}