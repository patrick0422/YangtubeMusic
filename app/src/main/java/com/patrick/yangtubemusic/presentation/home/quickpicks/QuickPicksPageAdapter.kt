package com.patrick.yangtubemusic.presentation.home.quickpicks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrick.yangtubemusic.data.Music
import com.patrick.yangtubemusic.databinding.PageQuickPicksBinding

class QuickPicksPageAdapter(
    private val onItemClick: (Music) -> Unit,
    private val onItemLongClick: (Music) -> Unit,
    private val onMoreClick: (Music) -> Unit
): RecyclerView.Adapter<QuickPicksPageViewHolder>() {
    var quickPicksPageList: List<Array<Music>> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickPicksPageViewHolder = QuickPicksPageViewHolder.from(
        parent,
        onItemClick,
        onItemLongClick,
        onMoreClick
    )

    override fun onBindViewHolder(holder: QuickPicksPageViewHolder, position: Int) = holder.bind(quickPicksPageList[position])

    override fun getItemCount(): Int = quickPicksPageList.size
}

class QuickPicksPageViewHolder(
    private val binding: PageQuickPicksBinding,
    private val onItemClick: (Music) -> Unit,
    private val onItemLongClick: (Music) -> Unit,
    private val onMoreClick: (Music) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(
            parent: ViewGroup,
            onItemClick: (Music) -> Unit,
            onItemLongClick: (Music) -> Unit,
            onMoreClick: (Music) -> Unit
        ): QuickPicksPageViewHolder = QuickPicksPageViewHolder(
            PageQuickPicksBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick,
            onItemLongClick,
            onMoreClick
        )
    }

    fun bind(musicList: Array<Music>) = with(binding) {
        listOf(
            quickPicksItem1, quickPicksItem2, quickPicksItem3, quickPicksItem4
        ).forEachIndexed { index, quickPicksItem ->
            with(quickPicksItem) {
                musicData = musicList[index]
                setOnClickListener { onItemClick(it) }
                setOnLongClickListener { onItemLongClick(it) }
                setOnMoreClickListener { onMoreClick(it) }
            }
        }
    }
}
