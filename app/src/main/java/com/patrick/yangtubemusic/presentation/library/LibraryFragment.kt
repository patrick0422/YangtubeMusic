package com.patrick.yangtubemusic.presentation.library

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.databinding.FragmentLibraryBinding
import com.patrick.yangtubemusic.presentation.common.CommonItemListAdapter
import com.patrick.yangtubemusic.util.Constants.musicList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
                    openPlaylistBottomSheet(content)
                }
            }
        }
    )

    override fun init() = with(binding) {
        loadRecentActivity()

        swipeRefreshLayout.setOnRefreshListener { onRefresh() }
        buttonDownload.setOnClickListener { goToDownload() }
        buttonPlaylists.setOnClickListener { goToPlaylists() }
        buttonAlbums.setOnClickListener { goToAlbums() }
        buttonSongs.setOnClickListener { goToSongs() }
        buttonArtists.setOnClickListener { goToArtists() }
        buttonSubscriptions.setOnClickListener { goToSubscriptions() }
    }

    private fun onRefresh() {
        lifecycleScope.launch {
            delay(1000)
            binding.swipeRefreshLayout.isRefreshing = false
        }
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

    private fun openPlaylistBottomSheet(playlist: Content.Playlist) {
        findNavController().navigate(LibraryFragmentDirections.actionLibraryFragmentToPlaylistBottomSheet(playlist))
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