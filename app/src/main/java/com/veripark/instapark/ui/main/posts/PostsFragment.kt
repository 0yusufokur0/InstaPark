package com.veripark.instapark.ui.main.posts

import android.os.Bundle
import com.veripark.instapark.R
import com.veripark.instapark.databinding.FragmentPostsBinding
import com.veripark.instapark.ui.base.BaseFragment

class PostsFragment :BaseFragment<FragmentPostsBinding,PostsViewModel>
    (R.layout.fragment_posts,PostsViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        println("posts")

    }
}