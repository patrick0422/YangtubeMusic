package com.patrick.yangtubemusic.util

import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.data.Contents


object Constants {
    const val TAG = "YangtubeMusic"

    val musicList = listOf(
        Content.Music(
            "내 기쁨은 네가 벤틀리를 타는 거야",
            "김승민",
            "https://lh3.googleusercontent.com/yZTtpy3PXhUx6BaUl-SxiDDqWvI-VfAGHvGpUfQOosEMqMstR10_9HecHd1u0w0vNrota6BGNk_HDg4=w120-h120-l90-rj",
            true
        ),
        Content.Music(
            "Me & You ◑",
            "HONNE(혼네)",
            "https://lh3.googleusercontent.com/XnLiu9JAt_Z4GDTeLlVQ1EVgFXS1xdQcVRDeh83whiC5TQgmboVuQsKmQU0L8Bx7uhqpgrpfZnnl1HFZ=w120-h120-l90-rj",
            false
        ),
        Content.Music(
            "니가 돌아올 희망은 없다는 걸 알아",
            "경제환",
            "https://lh3.googleusercontent.com/_At5xpPD0paZRRwN9KOLpnvc2yOwjWNVSBm6Es77cM6dC5sk15BKgsI9AQj8b97CyU-l1swqbOpPKkw=w120-h120-l90-rj"
        ),
        Content.Music(
            "Tomorrow(feat. 기리보이(Giriboy), 빅나티)",
            "lIlBOI",
            "https://lh3.googleusercontent.com/pixroKTrwwEDqLTP3wPA8ePRMvWBz4u4K_XVqeahLEEQ2ySdYXM_5x-qIt6PKB9S6eHzw_3vKcOURlCVCw=w120-h120-l90-rj"
        ),
        Content.Music(
            "노래방에서",
            "장범준",
            "https://lh3.googleusercontent.com/fgN9gCK4kYnade5hhF6mrbjt4FJGsxi1NO4zM1EVEXkJS8D6cJBXPOPP-wq_t-gmZYOcp5WU80uFNHxZ9A=w120-h120-l90-rj",
            true
        ),
        Content.Music(
            "아는사람 얘기",
            "San E",
            "https://lh3.googleusercontent.com/Yb6RcL7BT5rPNe8HDuD4AChseI3vAueWVYBAIbOiI_wcxv9rICitCuPOVPoi9JlotjW0RjS9fxj1HOw=w120-h120-l90-rj",
            false
        ),
        Content.Music(
            "신호등",
            "이무진",
            "https://lh3.googleusercontent.com/o4jX-7hnRDn_RQkrYITMnP91k99QXW8CPcOYGWN4H8kB01eP56F2OUwDeZ-ohCS2P2h6SxgHhjpiY2gJ=w120-h120-l90-rj"
        ),
        Content.Music(
            "헤어지지 못하는 여자, 떠나가지 못하는 남자 Can't Breakup Girl, Can't Breakaway Boy(feat. Jung In)",
            "리쌍",
            "https://lh3.googleusercontent.com/A0nTQjof_ndZo2etRfs185BDhGRgKrZqOx1O4wnm8GFQhNLlLSE73nXMb6w2AkroMOjSsVtpzGamUEle=w120-h120-l90-rj"
        ),
    )

    val artistList = listOf(
        Content.Artist(
            name = "릴러말즈",
            thumbnailUrl = "https://lh3.googleusercontent.com/wDx5-7NMG4rQSD8j5MEBcUnZmYvCxbs1cA7CnsW32Ljegc9f0WnSo-jD_6I1FSCU0RPBf47xGdyiXIU=w120-h120-p-l90-rj"
        ),
        Content.Artist(
            name = "윤하",
            thumbnailUrl = "https://lh3.googleusercontent.com/DwgTrAJOIrJ87SSPLTixftV_xG4ZXgerAxxX9-ipiJV9nNg7ySVq00Tebt7_cJt_1ThdeHddsi3j8w=w120-h120-p-l90-rj"
        )
    )

    val quickPickList = listOf(
        arrayOf(
            Content.Music(
                "내 기쁨은 네가 벤틀리를 타는 거야",
                "김승민",
                "https://lh3.googleusercontent.com/yZTtpy3PXhUx6BaUl-SxiDDqWvI-VfAGHvGpUfQOosEMqMstR10_9HecHd1u0w0vNrota6BGNk_HDg4=w120-h120-l90-rj",
                true
            ),
            Content.Music(
                "Me & You ◑",
                "HONNE(혼네)",
                "https://lh3.googleusercontent.com/XnLiu9JAt_Z4GDTeLlVQ1EVgFXS1xdQcVRDeh83whiC5TQgmboVuQsKmQU0L8Bx7uhqpgrpfZnnl1HFZ=w120-h120-l90-rj",
                false
            ),
            Content.Music(
                "니가 돌아올 희망은 없다는 걸 알아",
                "경제환",
                "https://lh3.googleusercontent.com/_At5xpPD0paZRRwN9KOLpnvc2yOwjWNVSBm6Es77cM6dC5sk15BKgsI9AQj8b97CyU-l1swqbOpPKkw=w120-h120-l90-rj"
            ),
            Content.Music(
                "Tomorrow(feat. 기리보이(Giriboy), 빅나티)",
                "lIlBOI",
                "https://lh3.googleusercontent.com/pixroKTrwwEDqLTP3wPA8ePRMvWBz4u4K_XVqeahLEEQ2ySdYXM_5x-qIt6PKB9S6eHzw_3vKcOURlCVCw=w120-h120-l90-rj"
            ),
        ),
        arrayOf(
            Content.Music(
                "노래방에서",
                "장범준",
                "https://lh3.googleusercontent.com/fgN9gCK4kYnade5hhF6mrbjt4FJGsxi1NO4zM1EVEXkJS8D6cJBXPOPP-wq_t-gmZYOcp5WU80uFNHxZ9A=w120-h120-l90-rj",
                true
            ),
            Content.Music(
                "아는사람 얘기",
                "San E",
                "https://lh3.googleusercontent.com/Yb6RcL7BT5rPNe8HDuD4AChseI3vAueWVYBAIbOiI_wcxv9rICitCuPOVPoi9JlotjW0RjS9fxj1HOw=w120-h120-l90-rj",
                false
            ),
            Content.Music(
                "신호등",
                "이무진",
                "https://lh3.googleusercontent.com/o4jX-7hnRDn_RQkrYITMnP91k99QXW8CPcOYGWN4H8kB01eP56F2OUwDeZ-ohCS2P2h6SxgHhjpiY2gJ=w120-h120-l90-rj"
            ),
            Content.Music(
                "헤어지지 못하는 여자, 떠나가지 못하는 남자 Can't Breakup Girl, Can't Breakaway Boy(feat. Jung In)",
                "리쌍",
                "https://lh3.googleusercontent.com/A0nTQjof_ndZo2etRfs185BDhGRgKrZqOx1O4wnm8GFQhNLlLSE73nXMb6w2AkroMOjSsVtpzGamUEle=w120-h120-l90-rj"
            ),
        ),
        arrayOf(
            Content.Music(
                "Me & You ◑",
                "HONNE(혼네)",
                "https://lh3.googleusercontent.com/XnLiu9JAt_Z4GDTeLlVQ1EVgFXS1xdQcVRDeh83whiC5TQgmboVuQsKmQU0L8Bx7uhqpgrpfZnnl1HFZ=w120-h120-l90-rj"
            ),
            Content.Music(
                "니가 돌아올 희망은 없다는 걸 알아",
                "경제환",
                "https://lh3.googleusercontent.com/_At5xpPD0paZRRwN9KOLpnvc2yOwjWNVSBm6Es77cM6dC5sk15BKgsI9AQj8b97CyU-l1swqbOpPKkw=w120-h120-l90-rj"
            ),
            Content.Music(
                "내 기쁨은 네가 벤틀리를 타는 거야",
                "김승민",
                "https://lh3.googleusercontent.com/yZTtpy3PXhUx6BaUl-SxiDDqWvI-VfAGHvGpUfQOosEMqMstR10_9HecHd1u0w0vNrota6BGNk_HDg4=w120-h120-l90-rj"
            ),
            Content.Music(
                "Tomorrow(feat. 기리보이(Giriboy), 빅나티)",
                "lIlBOI",
                "https://lh3.googleusercontent.com/pixroKTrwwEDqLTP3wPA8ePRMvWBz4u4K_XVqeahLEEQ2ySdYXM_5x-qIt6PKB9S6eHzw_3vKcOURlCVCw=w120-h120-l90-rj"
            ),
        ),
        arrayOf(
            Content.Music(
                "아는사람 얘기",
                "San E",
                "https://lh3.googleusercontent.com/Yb6RcL7BT5rPNe8HDuD4AChseI3vAueWVYBAIbOiI_wcxv9rICitCuPOVPoi9JlotjW0RjS9fxj1HOw=w120-h120-l90-rj",
                false
            ),
            Content.Music(
                "헤어지지 못하는 여자, 떠나가지 못하는 남자 Can't Breakup Girl, Can't Breakaway Boy(feat. Jung In)",
                "리쌍",
                "https://lh3.googleusercontent.com/A0nTQjof_ndZo2etRfs185BDhGRgKrZqOx1O4wnm8GFQhNLlLSE73nXMb6w2AkroMOjSsVtpzGamUEle=w120-h120-l90-rj"
            ),
            Content.Music(
                "신호등",
                "이무진",
                "https://lh3.googleusercontent.com/o4jX-7hnRDn_RQkrYITMnP91k99QXW8CPcOYGWN4H8kB01eP56F2OUwDeZ-ohCS2P2h6SxgHhjpiY2gJ=w120-h120-l90-rj"
            ),
            Content.Music(
                "노래방에서",
                "장범준",
                "https://lh3.googleusercontent.com/fgN9gCK4kYnade5hhF6mrbjt4FJGsxi1NO4zM1EVEXkJS8D6cJBXPOPP-wq_t-gmZYOcp5WU80uFNHxZ9A=w120-h120-l90-rj",
                true
            ),
        ),
        arrayOf(
            Content.Music(
                "내 기쁨은 네가 벤틀리를 타는 거야",
                "김승민",
                "https://lh3.googleusercontent.com/yZTtpy3PXhUx6BaUl-SxiDDqWvI-VfAGHvGpUfQOosEMqMstR10_9HecHd1u0w0vNrota6BGNk_HDg4=w120-h120-l90-rj"
            ),
            Content.Music(
                "니가 돌아올 희망은 없다는 걸 알아",
                "경제환",
                "https://lh3.googleusercontent.com/_At5xpPD0paZRRwN9KOLpnvc2yOwjWNVSBm6Es77cM6dC5sk15BKgsI9AQj8b97CyU-l1swqbOpPKkw=w120-h120-l90-rj"
            ),
            Content.Music(
                "Tomorrow(feat. 기리보이(Giriboy), 빅나티)",
                "lIlBOI",
                "https://lh3.googleusercontent.com/pixroKTrwwEDqLTP3wPA8ePRMvWBz4u4K_XVqeahLEEQ2ySdYXM_5x-qIt6PKB9S6eHzw_3vKcOURlCVCw=w120-h120-l90-rj"
            ),
            Content.Music(
                "Me & You ◑",
                "HONNE(혼네)",
                "https://lh3.googleusercontent.com/XnLiu9JAt_Z4GDTeLlVQ1EVgFXS1xdQcVRDeh83whiC5TQgmboVuQsKmQU0L8Bx7uhqpgrpfZnnl1HFZ=w120-h120-l90-rj"
            ),
        ),
    )

    val contentsLists = listOf(
        Contents.ListenAgain(
            content = musicList
        ),
        Contents.MixedForYou(
            content = listOf(
                Content.PlayList(
                    name = "나만을 위한 맞춤 믹스 1",
                    thumbnailUrl = "",
                    playList = musicList
                )
            )
        ),
        Contents.ContentRecommendationByArtist(
            thumbnailUrl = "https://lh3.googleusercontent.com/i8X3ZfCXsECKcP-ZstTp2FgJ-asKl0VZxG-3i_M-nyyfJmzDrXjYvghSLGteM295zaG-vvAsq-zpX_w=w120-h120-l90-rj",
            contentTitle = "기리보이",
            content = artistList
        )
    )
}