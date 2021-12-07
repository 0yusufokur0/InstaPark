package com.veripark.instapark.ui.main.detail

import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.resurrection.imkb.util.toast
import com.veripark.instapark.R
import com.veripark.instapark.data.model.users.UsersModelItem
import com.veripark.instapark.databinding.ActivityDetailBinding
import com.veripark.instapark.ui.base.BaseActivity
import com.veripark.instapark.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>
    (R.layout.activity_detail, DetailViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {

        val str = intent.getStringExtra("userItemModel")

        Gson().fromJson(str, UsersModelItem::class.java)?.let {
            binding.userModelItem = it
            viewModel.getUsers(it.id.toString())
        }

        viewModel.user.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let {
                        binding.userModelItem = it
                        toast(this,"Updated")
                        binding.container.setBackgroundColor(Color.DKGRAY)
                    }
                }
                Status.ERROR -> {
                    toast(this, "Error")
                }
                Status.LOADING -> {
                    toast(this, "Loading")
                }
            }
        })

    }
}