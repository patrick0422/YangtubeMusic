package com.patrick.yangtubemusic

import com.google.android.material.chip.Chip
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.databinding.FragmentHomeBinding


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

    override fun init() {
        addChip()
    }

    private fun addChip() {
        chipList.forEach { chip ->
            binding.chipList.addView(chip)
        }
    }

    override fun onPause() {
        super.onPause()

        binding.chipList.removeAllViews()
    }
}