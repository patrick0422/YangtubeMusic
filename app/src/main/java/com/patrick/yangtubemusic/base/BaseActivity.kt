package com.patrick.yangtubemusic.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity() {
    val binding: B by lazy { DataBindingUtil.setContentView(this, layoutResId) }
    private var waitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this@BaseActivity

        init()
    }

    abstract fun init()

    fun makeToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}