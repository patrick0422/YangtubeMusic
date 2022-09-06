package com.patrick.yangtubemusic.presentation.explore

import androidx.lifecycle.lifecycleScope
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseFragment
import com.patrick.yangtubemusic.databinding.FragmentExploreBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ExploreFragment : BaseFragment<FragmentExploreBinding>(R.layout.fragment_explore) {
    override fun init() {
        binding.swipeRefreshLayout.setOnRefreshListener { onRefresh() }
    }

    private fun onRefresh() {
        lifecycleScope.launch {
            delay(1000)
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}