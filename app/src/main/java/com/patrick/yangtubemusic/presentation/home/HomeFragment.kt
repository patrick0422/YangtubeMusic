package com.patrick.yangtubemusic.presentation.home

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.chip.Chip
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.data.Content.Music
import com.patrick.yangtubemusic.databinding.FragmentHomeBinding
import com.patrick.yangtubemusic.presentation.home.contents.ContentListAdapter
import com.patrick.yangtubemusic.presentation.home.quickpicks.QuickPicksPageAdapter
import com.patrick.yangtubemusic.util.Constants.contentsLists
import com.patrick.yangtubemusic.util.Constants.quickPickList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val quickPicksPageAdapter by lazy {
        QuickPicksPageAdapter(
            onItemClick = { music: Music ->
                playMusic(music)
            },
            onItemLongClick = { music: Music ->
                openControlBottomSheet(music)

            },
            onMoreClick = { music: Music ->
                openControlBottomSheet(music)
            },
        )
    }

    private val contentListAdapter by lazy { ContentListAdapter(findNavController()) }

    override fun init() {
        addChip()
        loadQuickPicks()
        loadContents()
        binding.swipeRefreshLayout.setOnRefreshListener { onRefresh() }
    }

    private fun onRefresh() {
        lifecycleScope.launch {
            delay(1000)
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun playMusic(music: Music) {
        makeToast(music.title)
    }

    private fun openControlBottomSheet(music: Music) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMusicBottomSheet(music))
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadQuickPicks() = with(binding.quickPicksViewPager) {
        orientation = ViewPager2.ORIENTATION_HORIZONTAL
        getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        offscreenPageLimit = 2

        setPageTransformer { page, position ->
            val pageTranslationX = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                40F,
                requireContext().resources.displayMetrics
            )
            page.translationX = -pageTranslationX * (position)
        }

        quickPicksPageAdapter.quickPicksPageList = quickPickList
        quickPicksPageAdapter.notifyDataSetChanged()

        adapter = quickPicksPageAdapter
    }

    private fun loadContents() {
        contentListAdapter.submitList(contentsLists)

        binding.contentsRecyclerView.adapter = contentListAdapter
    }

    private fun addChip() {
        listOf(
            "운동",
            "휴식",
            "에너지 충전",
            "집중",
            "출퇴근 & 등하교"
        ).forEach { chipText ->
            val chip = Chip(requireContext()).apply {
                isCheckable = true
                isChipIconVisible = false
                isCheckedIconVisible = false
                isCloseIconVisible = false
                text = chipText
                setTextColor(resources.getColorStateList(R.color.chip_text_selector, null))
                setChipBackgroundColorResource(R.color.chip_background_selector)
            }

            binding.chipList.addView(chip)
        }

        binding.chipList.setOnCheckedStateChangeListener { group, _ ->
            group.checkedChipId.let {
                if (it != View.NO_ID) {
                    val chip = binding.root.findViewById<Chip>(group.checkedChipId)
                    makeToast(chip.text.toString())
                }
            }
        }
    }
}