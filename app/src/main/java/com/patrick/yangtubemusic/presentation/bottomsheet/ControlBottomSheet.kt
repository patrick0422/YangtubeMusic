package com.patrick.yangtubemusic.presentation.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.patrick.yangtubemusic.databinding.BottomSheetControlBinding

class ControlBottomSheet : BottomSheetDialogFragment() {
    private val binding: BottomSheetControlBinding by lazy { BottomSheetControlBinding.inflate(layoutInflater) }
    private val args: ControlBottomSheetArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding) {
        val music = args.music

        imageMusicThumbnail.load(music.thumbnailUrl)
        textMusicTitle.text = music.title
        textMusicArtist.text = music.artist

        return root
    }

    // https://stackoverflow.com/questions/45614271/bottomsheetdialogfragment-doesnt-show-full-height-in-landscape-mode/61813321#61813321:~:text=This%20worked%20for%20me%20and%20was%20the%20cleanest%20approach%3A
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        return dialog
    }
}