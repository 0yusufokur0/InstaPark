package com.veripark.instapark.ui.main.photos

import android.os.Bundle
import com.veripark.instapark.R
import com.veripark.instapark.ui.base.BaseFragment
import com.veripark.instapark.databinding.FragmentPostsBinding

class PhotosFragment : BaseFragment<FragmentPostsBinding, PhotosViewModel>
    (R.layout.fragment_photos,PhotosViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        println("photos")

    }
}