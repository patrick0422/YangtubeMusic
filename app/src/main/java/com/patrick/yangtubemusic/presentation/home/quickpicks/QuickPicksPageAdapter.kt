package com.patrick.yangtubemusic.presentation.home.quickpicks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patrick.yangtubemusic.databinding.PageQuickPicksBinding

class QuickPicksPageAdapter: RecyclerView.Adapter<QuickPicksPageViewHolder>() {
    var quickPicksPageList: List<Array<MusicCompact>> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickPicksPageViewHolder = QuickPicksPageViewHolder.from(parent)

    override fun onBindViewHolder(holder: QuickPicksPageViewHolder, position: Int) = holder.bind(quickPicksPageList[position])

    override fun getItemCount(): Int = quickPicksPageList.size
}

class QuickPicksPageViewHolder(
    private val binding: PageQuickPicksBinding
): RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): QuickPicksPageViewHolder = QuickPicksPageViewHolder(
            PageQuickPicksBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun bind(musicList: Array<MusicCompact>) = with(binding) {
        quickPicksItem1.musicData = musicList[0]
        quickPicksItem2.musicData = musicList[1]
        quickPicksItem3.musicData = musicList[2]
        quickPicksItem4.musicData = musicList[3]
    }
}

data class MusicCompact(
    val title: String,
    val artist: String,
    val thumbnailUrl: String
)
