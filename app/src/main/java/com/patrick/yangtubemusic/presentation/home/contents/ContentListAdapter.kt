package com.patrick.yangtubemusic.presentation.home.contents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.data.Content.*
import com.patrick.yangtubemusic.data.Contents
import com.patrick.yangtubemusic.databinding.ItemDynamicContentBinding
import com.patrick.yangtubemusic.presentation.common.CommonItemListAdapter
import com.patrick.yangtubemusic.presentation.home.HomeFragmentDirections

class ContentListAdapter(
    private val navController: NavController
): ListAdapter<Contents, ContentViewHolder>(
    object : DiffUtil.ItemCallback<Contents>() {
        override fun areItemsTheSame(oldItem: Contents, newItem: Contents): Boolean = oldItem === newItem

        override fun areContentsTheSame(oldItem: Contents, newItem: Contents): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder =
        ContentViewHolder.from(parent, navController)

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) = holder.bind(getItem(position))
}

class ContentViewHolder(
    private val binding: ItemDynamicContentBinding,
    private val navController: NavController
): RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(
            parent: ViewGroup,
            navController: NavController
        ): ContentViewHolder = ContentViewHolder(
            ItemDynamicContentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            navController
        )
    }

    private val commonItemListAdapter = CommonItemListAdapter(
        onClick = { content ->
            when (content) {
                is Music -> {
                    Toast.makeText(binding.root.context, content.title, Toast.LENGTH_SHORT).show()
                }
                is Artist -> {
                    Toast.makeText(binding.root.context, content.name, Toast.LENGTH_SHORT).show()
                }
                is PlayList -> {
                    Toast.makeText(binding.root.context, content.name, Toast.LENGTH_SHORT).show()
                }
            }
        },
        onLongClick = { content ->
            when (content) {
                is Music -> {
                    openControlBottomSheet(content)
                }
                is Artist -> {
                    //TODO
                }
                is PlayList -> {
                    //TODO
                }
            }
        }
    )

    private fun openControlBottomSheet(music: Music) {
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToControlBottomSheet(music))
    }

    fun bind(contents: Contents) = with(binding) {
        when(contents) {
            is Contents.ListenAgain -> {
                imageContentThumbnail.visibility = View.GONE
                textContentTitle.text = root.context.getString(R.string.listen_again)
                textContentDescription.visibility = View.GONE
                contentDescriptionWrap.setOnClickListener { Toast.makeText(root.context, root.resources.getString(R.string.listen_again), Toast.LENGTH_SHORT).show() }

                commonItemListAdapter.submitList(contents.content)
            }
            is Contents.MixedForYou -> {
                imageContentThumbnail.visibility = View.GONE
                textContentTitle.text = root.context.getString(R.string.mixed_for_you)
                textContentDescription.visibility = View.GONE
                contentDescriptionWrap.setOnClickListener { Toast.makeText(root.context, root.resources.getString(R.string.mixed_for_you), Toast.LENGTH_SHORT).show() }

                commonItemListAdapter.submitList(contents.content)
            }
            is Contents.ContentRecommendationByArtist -> {
                imageContentThumbnail.load(contents.iconUrl)
                textContentTitle.text = contents.contentTitle
                textContentDescription.text = root.context.getString(R.string.similar_to)
                contentDescriptionWrap.setOnClickListener { Toast.makeText(root.context, contents.contentTitle, Toast.LENGTH_SHORT).show() }

                commonItemListAdapter.submitList(contents.content)
            }
        }

        contentList.adapter = commonItemListAdapter
    }
}