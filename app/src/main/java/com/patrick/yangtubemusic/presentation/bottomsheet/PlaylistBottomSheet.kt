package com.patrick.yangtubemusic.presentation.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.patrick.yangtubemusic.data.Content.Playlist
import com.patrick.yangtubemusic.databinding.BottomSheetPlaylistBinding

class PlaylistBottomSheet : BottomSheetDialogFragment() {
    private val binding by lazy { BottomSheetPlaylistBinding.inflate(layoutInflater) }
    private val args: PlaylistBottomSheetArgs by navArgs()

    private val playlist: Playlist by lazy { args.playlist }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding) {
        imagePlaylistThumbnail.load(playlist.thumbnailUrl)
        textPlaylistName.text = playlist.name
        textPlaylistDescription.text = playlist.description
        textPlaylistDescription.isSelected   = true

        buttonShufflePlay.setOnClickListener { onShufflePlay() }
        buttonPlayNext.setOnClickListener { onPlayNext() }
        buttonAddToQueue.setOnClickListener { onAddToQueue() }
        buttonLibrary.setOnClickListener { onLibrary() }
        buttonDownload.setOnClickListener { onDownload() }
        buttonAddToPlaylist.setOnClickListener { onAddToPlaylist() }

        return root
    }

    private fun onShufflePlay() {
        makeToast("셔플 재생")
    }

    private fun onPlayNext() {
        makeToast("다음 재생")
    }

    private fun onAddToQueue() {
        makeToast("목록에 추가")
    }

    private fun onLibrary() {
        makeToast("보관함에 추가")
    }

    private fun onDownload() {
        makeToast("오프라인 저장")
    }

    private fun onAddToPlaylist() {
        makeToast("재생목록에 추가")
    }

    private fun makeToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}