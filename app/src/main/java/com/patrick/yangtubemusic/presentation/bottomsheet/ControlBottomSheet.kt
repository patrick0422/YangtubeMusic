package com.patrick.yangtubemusic.presentation.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.data.Music
import com.patrick.yangtubemusic.databinding.BottomSheetControlBinding
import com.patrick.yangtubemusic.util.Constants
import com.patrick.yangtubemusic.util.Constants.TAG

class ControlBottomSheet : BottomSheetDialogFragment() {
    private val binding: BottomSheetControlBinding by lazy { BottomSheetControlBinding.inflate(layoutInflater) }
    private val args: ControlBottomSheetArgs by navArgs()

    private val music: Music by lazy { args.music }

    //TODO: 실제 값을 받아오게 된다면 변수 tempLikeStatusForTest를 삭제하고 실제 값을 대입해 사용해야 함
    private var tempLikeStatusForTest: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding) {

        imageMusicThumbnail.load(music.thumbnailUrl)
        textMusicTitle.text = music.title
        textMusicArtist.text = music.artist

        //TODO: 실제 값을 받아오게 된다면 변수 tempLikeStatusForTest를 삭제하고 실제 값을 대입해 사용해야 함
        tempLikeStatusForTest = music.likeStatus
        setLikeStatus()

        buttonThumbDown.setOnClickListener { onDislike() }
        buttonThumbUp.setOnClickListener { onLike() }
        buttonStartRadio.setOnClickListener { onStartRadio() }
        buttonPlayNext.setOnClickListener { onPlayNext() }
        buttonAddToQueue.setOnClickListener { onAddToQueue() }
        buttonRemoveFromLibrary.setOnClickListener { onRemoveFromLibrary() }
        buttonDownload.setOnClickListener { onDownload() }
        buttonAddToPlaylist.setOnClickListener { onAddToPlaylist() }
        buttonGoToAlbum.setOnClickListener { onGoToAlbum() }
        buttonGoToArtist.setOnClickListener { onGoToArtist() }
        buttonShare.setOnClickListener { onShare() }

        return root
    }

    //TODO: 실제 값을 받아오게 된다면 변수 tempLikeStatusForTest를 삭제하고 실제 값을 대입해 사용해야 함
    private fun onDislike() {
        if (tempLikeStatusForTest == false) { // 싫어요 취소
            tempLikeStatusForTest = null

            setLikeStatus()
        }
        else { // 싫어요
            tempLikeStatusForTest = false

//            makeSnackbar("확인되었습니다, 맞춤 콘텐츠에 반영됩니다.")
            setLikeStatus()
        }

//        this@ControlBottomSheet.dismiss()
    }

    //TODO: 실제 값을 받아오게 된다면 변수 tempLikeStatusForTest를 삭제하고 실제 값을 대입해 사용해야 함
    private fun onLike() {
        if (tempLikeStatusForTest == true) { // 좋아요 취소
            tempLikeStatusForTest = null

//            makeSnackbar("좋아요 표시한 콘텐츠에서 삭제되었습니다.")
            setLikeStatus()
        }
        else { // 좋아요
            tempLikeStatusForTest = true

//            makeSnackbar("좋아요 표시한 콘텐츠에 추가되었습니다.")
            setLikeStatus()
        }

//        this@ControlBottomSheet.dismiss()
    }

    //TODO: 실제 값을 받아오게 된다면 변수 tempLikeStatusForTest를 삭제하고 실제 값을 대입해 사용해야 함
    private fun setLikeStatus() = with(binding) {
        when (tempLikeStatusForTest) {
            null -> {
                buttonThumbUp.setImageResource(R.drawable.ic_thumb_up)
                buttonThumbDown.setImageResource(R.drawable.ic_thumb_down)
            }
            false -> {
                buttonThumbUp.setImageResource(R.drawable.ic_thumb_up)
                buttonThumbDown.setImageResource(R.drawable.ic_thumb_down_filled)
            }
            true -> {
                buttonThumbUp.setImageResource(R.drawable.ic_thumb_up_filled)
                buttonThumbDown.setImageResource(R.drawable.ic_thumb_down)
            }
        }
    }

    private fun onStartRadio() {
        makeToast("뮤직 스테이션 시작")
    }

    private fun onPlayNext() {
        makeToast("다음 재생")
    }

    private fun onAddToQueue() {
        makeToast("목록에 추가")
    }

    private fun onRemoveFromLibrary() {
        makeToast("보관함에 추가")
    }

    private fun onDownload() {
        makeToast("오프라인 저장")
    }

    private fun onAddToPlaylist() {
        makeToast("재생목록에 추가")
    }

    private fun onGoToAlbum() {
        makeToast("앨범으로 이동")
    }

    private fun onGoToArtist() {
        makeToast("아티스트 페이지로 이동")
    }

    private fun onShare() {
        makeToast("공유")
    }

    private fun makeToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    private fun makeSnackbar(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
    }

    // https://stackoverflow.com/questions/45614271/bottomsheetdialogfragment-doesnt-show-full-height-in-landscape-mode/61813321#61813321:~:text=This%20worked%20for%20me%20and%20was%20the%20cleanest%20approach%3A
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        return dialog
    }
}