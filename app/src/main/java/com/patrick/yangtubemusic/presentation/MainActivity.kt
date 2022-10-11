package com.patrick.yangtubemusic.presentation

import android.graphics.Color
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseActivity
import com.patrick.yangtubemusic.data.Content
import com.patrick.yangtubemusic.databinding.ActivityMainBinding
import com.patrick.yangtubemusic.util.Constants.musicList

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var navController: NavController

    override fun init() {
        val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment }
        navController = navHostFragment.navController

        setUpBottomNav()
        setTransparent()

        setData(musicList[0])
    }

    fun setData(music: Content.Music) {
        binding.collapsiblePlayer.setData(music)
    }

    private fun setTransparent() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        if(Build.VERSION.SDK_INT >= 30) {	// API 30 이상에 적용
            WindowCompat.setDecorFitsSystemWindows(window, true)
        }
        setPadding()
    }

    private fun setPadding() {
        binding.toolbar.updatePadding(top = statusBarHeight())
        binding.bottomNavigationView.updatePadding(bottom = navigationBarHeight())
    }

    private fun statusBarHeight(): Int {
        val resourceId = resources.getIdentifier(
            "status_bar_height",
            "dimen",
            "android"
        )
        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
    }
    private fun navigationBarHeight(): Int {
        val resourceId = resources.getIdentifier(
            "navigation_bar_height",
            "dimen",
            "android"
        )
        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
    }

    private fun setUpBottomNav() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.exploreFragment,
                R.id.libraryFragment
            )
        )
        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // TODO Home & Explore & Library 프래그먼트 간 전환 시에만 실행하도록 바꿔야 함
        navController.addOnDestinationChangedListener { _, _, _ ->
            binding.motionLayout.progress = 0F
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.toolbar_cast -> {

            true
        }
        R.id.toolbar_search -> {

            true
        }
        R.id.toolbar_account -> {

            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp() || super.onSupportNavigateUp()
}