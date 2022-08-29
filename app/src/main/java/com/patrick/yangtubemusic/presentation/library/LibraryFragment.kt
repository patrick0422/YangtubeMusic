package com.patrick.yangtubemusic.presentation.library

import androidx.navigation.fragment.findNavController
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.databinding.FragmentLibraryBinding
import com.patrick.yangtubemusic.presentation.common.CommonItemListAdapter
import com.patrick.yangtubemusic.util.Constants.musicList


class LibraryFragment : BaseFragment<FragmentLibraryBinding>(R.layout.fragment_library) {
    private val commonItemListAdapter = CommonItemListAdapter(
        onClick = { content ->
            when (content) {
                is Content.Music -> {
                    playMusic(content)
                }
                is Content.Artist -> {

                }
                is Content.Playlist -> {

                }
            }
        },
        onLongClick = { content ->
            when (content) {
                is Content.Music -> {
                    openMusicBottomSheet(content)
                }
                is Content.Artist -> {
                    openArtistBottomSheet(content)
                }
                is Content.Playlist -> {

                }
            }
        }
    )

    override fun init() = with(binding) {
        loadRecentActivity()

        buttonDownload.setOnClickListener { goToDownload() }
        buttonPlaylists.setOnClickListener { goToPlaylists() }
        buttonAlbums.setOnClickListener { goToAlbums() }
        buttonSongs.setOnClickListener { goToSongs() }
        buttonArtists.setOnClickListener { goToArtists() }
        buttonSubscriptions.setOnClickListener { goToSubscriptions() }
    }

    private fun loadRecentActivity() {
        commonItemListAdapter.submitList(musicList)

        binding.listRecentActivity.adapter = commonItemListAdapter
    }

    private fun playMusic(music: Content.Music) {
        makeToast(music.title)
    }

    private fun openMusicBottomSheet(music: Content.Music) {
        findNavController().navigate(LibraryFragmentDirections.actionLibraryFragmentToMusicBottomSheet(music))
    }

    private fun openArtistBottomSheet(artist: Content.Artist) {
        findNavController().navigate(LibraryFragmentDirections.actionLibraryFragmentToArtistBottomSheet(artist))
    }

    private fun goToDownload() {
        makeToast("Download")
    }

    private fun goToPlaylists() {
        makeToast("Playlist")
    }

    private fun goToAlbums() {
        makeToast("Albums")
    }

    private fun goToSongs() {
        makeToast("Songs")
    }

    private fun goToArtists() {
        makeToast("Artists")
    }

    private fun goToSubscriptions() {
        makeToast("Subscriptions")
    }
}