package com.patrick.yangtubemusic.presentation.home

import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.chip.Chip
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.databinding.FragmentHomeBinding
import com.patrick.yangtubemusic.presentation.home.quickpicks.MusicCompact
import com.patrick.yangtubemusic.presentation.home.quickpicks.QuickPicksPageAdapter
import com.patrick.yangtubemusic.util.Constants.mockList


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private fun getChip() = Chip(requireContext()).apply {
        isCheckable = true
        isChipIconVisible = false
        isCheckedIconVisible = false
        isCloseIconVisible = false
        setTextColor(resources.getColorStateList(R.color.chip_text_selector, null))
        setChipBackgroundColorResource(R.color.chip_background_selector)
    }
    private val chipList by lazy {
        listOf(
            getChip().apply { text = "운동" },
            getChip().apply { text = "휴식" },
            getChip().apply { text = "에너지 충전" },
            getChip().apply { text = "집중" },
            getChip().apply { text = "출퇴근 & 등하교" }
        )
    }
    private val quickPicksPageAdapter by lazy { QuickPicksPageAdapter() }

    override fun init() {
        addChip()
        loadQuickPicks()
    }

    private fun loadQuickPicks() = with(binding) {
        quickPicksViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        quickPicksViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        quickPicksViewPager.offscreenPageLimit = 2

        quickPicksViewPager.setPageTransformer { page, position ->
            val pageTranslationX = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                40F,
                requireContext().resources.displayMetrics
            )
            page.translationX = -pageTranslationX * (position)
        }


        quickPicksViewPager.adapter = quickPicksPageAdapter
        quickPicksPageAdapter.quickPicksPageList = mockList
        quickPicksPageAdapter.notifyDataSetChanged()
    }

    private fun addChip() {
        chipList.forEach { chip ->
            binding.chipList.addView(chip)
        }
    }

    override fun onStop() {
        super.onStop()

        binding.chipList.removeAllViews()
    }
}