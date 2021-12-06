package com.veripark.instapark.ui.users

import android.os.Bundle
import com.veripark.instapark.R
import com.veripark.instapark.ui.base.BaseFragment

import com.veripark.instapark.databinding.FragmentUsersBinding
import com.veripark.instapark.ui.posts.PostsViewModel

class UsersFragment : BaseFragment<FragmentUsersBinding,PostsViewModel>
    (R.layout.fragment_users,PostsViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {

    }
}