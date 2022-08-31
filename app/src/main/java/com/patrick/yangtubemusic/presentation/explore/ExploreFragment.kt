package com.patrick.yangtubemusic.presentation.explore

import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.databinding.FragmentExploreBinding
import com.patrick.yangtubemusic.presentation.MainActivity


class ExploreFragment : BaseFragment<FragmentExploreBinding>(R.layout.fragment_explore) {

    override fun init() {
        loadToolbar()
    }

    private fun loadToolbar() {
        (activity as MainActivity).let {
            it.setSupportActionBar(binding.toolbar)
            it.supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }
}