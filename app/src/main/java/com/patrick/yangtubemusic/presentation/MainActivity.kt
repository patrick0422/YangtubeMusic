package com.patrick.yangtubemusic.presentation

import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.patrick.yangtubemusic.R
import com.patrick.yangtubemusic.base.BaseActivity
import com.patrick.yangtubemusic.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var navController: NavController

    override fun init() {
        val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment }
        navController = navHostFragment.navController

        setUpBottomNav()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
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