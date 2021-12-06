package com.veripark.instapark.ui.main.users

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.resurrection.imkb.util.toast
import com.veripark.instapark.BR
import com.veripark.instapark.R
import com.veripark.instapark.data.model.users.UsersModelItem
import com.veripark.instapark.databinding.FragmentUsersBinding
import com.veripark.instapark.databinding.UserItemBinding
import com.veripark.instapark.ui.base.BaseAdapter
import com.veripark.instapark.ui.base.BaseFragment
import com.veripark.instapark.ui.main.MainActivity
import com.veripark.instapark.ui.main.detail.DetailActivity
import com.veripark.instapark.util.Status.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding, UsersViewModel>
    (R.layout.fragment_users, UsersViewModel::class.java) {

    override fun init(savedInstanceState: Bundle?) {
        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                SUCCESS -> {

                    it.data?.let {
                        binding.recyclerView.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                        binding.recyclerView.adapter  = BaseAdapter<UsersModelItem,UserItemBinding>(
                            R.layout.user_item,
                            it,
                            BR.userModelItem){

                            var intent = Intent(requireContext(),DetailActivity::class.java)
                            intent.putExtra("userItemModel",Gson().toJson(it))
                            startActivity(intent)



                        }
                    }



                }
                ERROR -> {

                }
                LOADING -> {

                }
            }
            toast(requireContext(),it.status.toString())

        })
    }

}

