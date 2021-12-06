package com.veripark.instapark.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.veripark.instapark.App

abstract class BaseActivity<VDB : ViewDataBinding,VM : ViewModel>
    (@LayoutRes private val layoutRes: Int,
     private val viewModelClass: Class<VM>
) : AppCompatActivity() {

    protected val viewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    open lateinit var binding: VDB

    abstract fun init(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        init(savedInstanceState)
    }


    fun getApp(): App {
        return application as App
    }



}