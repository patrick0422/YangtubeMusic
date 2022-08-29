package com.patrick.yangtubemusic.presentation.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.patrick.yangtubemusic.data.Content.Artist
import com.patrick.yangtubemusic.databinding.BottomSheetArtistBinding

class ArtistBottomSheet : BottomSheetDialogFragment() {
    private val binding by lazy { BottomSheetArtistBinding.inflate(layoutInflater) }
    private val args: ArtistBottomSheetArgs by navArgs()

    private val artist: Artist by lazy { args.artist }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding) {
        imageArtistThumbnail.load(artist.thumbnailUrl)
        textArtistName.text = artist.name
        textArtistSubscribers.text = artist.description

        buttonShufflePlay.setOnClickListener { onShufflePlay() }
        buttonStartRadio.setOnClickListener { onStartRadio() }
        buttonSubscribe.setOnClickListener { onSubscribe() }
        buttonShare.setOnClickListener { onShare() }

        return root
    }

    private fun onShufflePlay() {
        makeToast("셔플 재생")
    }

    private fun onStartRadio() {
        makeToast("뮤직 스테이션 시작")
    }

    private fun onSubscribe() {
        makeToast("구독")
    }

    private fun onShare() {
        makeToast("공유")
    }

    private fun makeToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}