package com.veripark.instapark.ui.main.users

import android.os.Bundle
import com.veripark.instapark.R
import com.veripark.instapark.ui.base.BaseFragment

import com.veripark.instapark.databinding.FragmentUsersBinding
import com.veripark.instapark.ui.main.posts.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding,UsersViewModel>
    (R.layout.fragment_users,UsersViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        /*viewModel.printUsers()*/
        viewModel.printUsers()
    }
}