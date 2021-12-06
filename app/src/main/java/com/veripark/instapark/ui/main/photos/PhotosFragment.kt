package com.veripark.instapark.ui.main.photos

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.resurrection.imkb.util.toast
import com.veripark.instapark.BR
import com.veripark.instapark.R
import com.veripark.instapark.data.model.photos.PhotoModelItem
import com.veripark.instapark.data.model.posts.PostModelItem
import com.veripark.instapark.databinding.FragmentPhotosBinding
import com.veripark.instapark.ui.base.BaseFragment
import com.veripark.instapark.databinding.FragmentPostsBinding
import com.veripark.instapark.databinding.PhotoItemBinding
import com.veripark.instapark.databinding.PostItemBinding
import com.veripark.instapark.ui.base.BaseAdapter
import com.veripark.instapark.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding, PhotosViewModel>
    (R.layout.fragment_photos,PhotosViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        viewModel.getPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                    it.data?.let {
                        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
                            /*LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)*/

                        binding.recyclerView.adapter  = BaseAdapter<PhotoModelItem, PhotoItemBinding>(
                            R.layout.photo_item,
                            it,
                            BR.photoItem){

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