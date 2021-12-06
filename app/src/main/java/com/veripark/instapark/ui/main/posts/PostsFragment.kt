package com.veripark.instapark.ui.main.posts

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.resurrection.imkb.util.toast
import com.veripark.instapark.BR
import com.veripark.instapark.R
import com.veripark.instapark.data.model.posts.PostModelItem
import com.veripark.instapark.data.model.users.UsersModelItem
import com.veripark.instapark.databinding.FragmentPostsBinding
import com.veripark.instapark.databinding.PostItemBinding
import com.veripark.instapark.databinding.UserItemBinding
import com.veripark.instapark.ui.base.BaseAdapter
import com.veripark.instapark.ui.base.BaseFragment
import com.veripark.instapark.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment :BaseFragment<FragmentPostsBinding,PostsViewModel>
    (R.layout.fragment_posts,PostsViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        viewModel.getPosts()
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                    it.data?.let {
                        binding.recyclerView.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                        binding.recyclerView.adapter  = BaseAdapter<PostModelItem,PostItemBinding>(
                            R.layout.post_item,
                            it,
                            BR.postItem){

                        }
                    }
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
            toast(requireContext(),it.status.toString())
            println(it.data)

        })

    }
}