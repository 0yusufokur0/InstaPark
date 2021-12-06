package com.veripark.instapark.ui.main.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.google.gson.Gson
import com.resurrection.imkb.util.toast
import com.veripark.instapark.R
import com.veripark.instapark.data.model.users.UsersModelItem
import com.veripark.instapark.databinding.ActivityDetailBinding
import com.veripark.instapark.ui.base.BaseActivity

class DetailActivity :BaseActivity<ActivityDetailBinding,DetailViewModel>
    (R.layout.activity_detail,DetailViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {

        var str = intent.getStringExtra("userItemModel")

         val gson = Gson()
        gson.fromJson(str, UsersModelItem::class.java)?.let {
            binding.userModelItem = it
        }

    }

}