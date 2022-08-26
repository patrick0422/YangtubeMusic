package com.patrick.yangtubemusic.presentation.library

import androidx.navigation.fragment.findNavController
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.data.Music
import com.patrick.yangtubemusic.databinding.FragmentLibraryBinding
import com.patrick.yangtubemusic.util.Constants.mockRecentActivityList


class LibraryFragment : BaseFragment<FragmentLibraryBinding>(R.layout.fragment_library) {
    private val recentActivityListAdapter = RecentActivityListAdapter(
        onClick = { music ->
            playMusic(music)
        },
        onLongClick = { music ->
            openControlBottomSheet(music)
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
        recentActivityListAdapter.submitList(mockRecentActivityList)

        binding.listRecentActivity.adapter = recentActivityListAdapter
    }

    private fun playMusic(music: Music) {
        makeToast(music.title)
    }

    private fun openControlBottomSheet(music: Music) {
        findNavController().navigate(LibraryFragmentDirections.actionLibraryFragmentToControlBottomSheet(music))
    }

    fun goToDownload() {
        makeToast("Download")
    }

    fun goToPlaylists() {
        makeToast("Playlist")
    }

    fun goToAlbums() {
        makeToast("Albums")
    }

    fun goToSongs() {
        makeToast("Songs")
    }

    fun goToArtists() {
        makeToast("Artists")
    }

    fun goToSubscriptions() {
        makeToast("Subscriptions")
    }
}