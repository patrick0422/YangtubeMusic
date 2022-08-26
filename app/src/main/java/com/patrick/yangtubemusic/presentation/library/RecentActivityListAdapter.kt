package com.patrick.yangtubemusic.presentation.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.patrick.yangtubemusic.data.Music
import com.patrick.yangtubemusic.databinding.ItemListCommonBigBinding

class RecentActivityListAdapter(
    private val onClick: (Music) -> Unit,
    private val onLongClick: (Music) -> Unit
) : ListAdapter<Music, RecentActivityViewHolder>(
    object : DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentActivityViewHolder =
        RecentActivityViewHolder.from(parent, onClick, onLongClick)

    override fun onBindViewHolder(holder: RecentActivityViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class RecentActivityViewHolder(
    private val binding: ItemListCommonBigBinding,
    private val onClick: (Music) -> Unit,
    private val onLongClick: (Music) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(
            parent: ViewGroup,
            onClick: (Music) -> Unit,
            onLongClick: (Music) -> Unit
        ): RecentActivityViewHolder = RecentActivityViewHolder(
            ItemListCommonBigBinding.inflate(LayoutInflater.from(parent.context)),
            onClick,
            onLongClick
        )
    }

    @SuppressLint("ClickableViewAccessibility")
    fun bind(music: Music) {
        with(binding) {
            imageItemThumbnail.load(music.thumbnailUrl)
            textItemTitle.text = music.title
            textItemSubtitle.text = "노래 · ${music.artist}"

            viewThumbnailOverlay.setOnClickListener { onClick(music) }
            viewThumbnailOverlay.setOnLongClickListener {
                onLongClick(music)
                true
            }

            layout.setOnTouchListener { _, _ ->
                viewThumbnailOverlay.isPressed = true

                false
            }

            layout.setOnClickListener {
                onClick(music)
            }
            layout.setOnLongClickListener {
                onLongClick(music)
                false
            }
        }
    }
}