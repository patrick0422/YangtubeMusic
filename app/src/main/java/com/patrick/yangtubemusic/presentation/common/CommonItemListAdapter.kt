package com.patrick.yangtubemusic.presentation.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.data.Content.Music
import com.patrick.yangtubemusic.data.Content.Artist
import com.patrick.yangtubemusic.data.Content.PlayList
import com.patrick.yangtubemusic.databinding.ItemListCommonBigBinding

class CommonItemListAdapter(
    private val onClick: (Content) -> Unit,
    private val onLongClick: (Content) -> Unit
) : ListAdapter<Content, CommonItemViewHolder>(
    object : DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonItemViewHolder =
        CommonItemViewHolder.from(parent, onClick, onLongClick)

    override fun onBindViewHolder(holder: CommonItemViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class CommonItemViewHolder(
    private val binding: ItemListCommonBigBinding,
    private val onClick: (Content) -> Unit,
    private val onLongClick: (Content) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(
            parent: ViewGroup,
            onClick: (Content) -> Unit,
            onLongClick: (Content) -> Unit
        ): CommonItemViewHolder = CommonItemViewHolder(
            ItemListCommonBigBinding.inflate(LayoutInflater.from(parent.context)),
            onClick,
            onLongClick
        )
    }

    @SuppressLint("ClickableViewAccessibility")
    fun bind(content: Content) {
        when(content) {
            is Music -> {
                bindMusic(content)
            }
            is Artist -> {
                bindArtist(content)
            }
            is PlayList -> {
                bindPlayList(content)
            }
        }
        setOnClickListener(content)
    }

    private fun setOnClickListener(content: Content) = with(binding) {
        viewThumbnailOverlay.setOnClickListener { onClick(content) }
        viewThumbnailOverlay.setOnLongClickListener {
            onLongClick(content)
            true
        }

        layout.setOnTouchListener { _, _ ->
            viewThumbnailOverlay.isPressed = true

            false
        }

        layout.setOnClickListener {
            onClick(content)
        }
        layout.setOnLongClickListener {
            onLongClick(content)
            false
        }
    }

    private fun bindMusic(music: Music) = with(binding) {
        imageItemThumbnail.load(music.thumbnailUrl)
        textItemTitle.text = music.title
        textItemSubtitle.text = "노래 · ${music.artist}"

    }

    private fun bindArtist(artist: Artist) = with(binding) {
        imagePlay.visibility = View.GONE
        imageItemThumbnail.load(artist.thumbnailUrl)
        textItemTitle.text = artist.name
        textItemSubtitle.text = artist.description

    }

    private fun bindPlayList(playList: PlayList) = with(binding) {
        imagePlay.visibility = View.GONE
        imageItemThumbnail.load(playList.thumbnailUrl)
        textItemTitle.text = playList.name
        textItemSubtitle.text = playList.description

    }
}