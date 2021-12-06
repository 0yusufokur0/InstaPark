package com.veripark.instapark.ui.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veripark.instapark.data.model.posts.PostModel
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.repository.InstaParkRepository
import com.veripark.instapark.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val instaParkRepository: InstaParkRepository) : ViewModel() {

    private val _posts = MutableLiveData<Resource<PostModel>>()
    val posts : LiveData<Resource<PostModel>> = _posts

    fun getPosts(){
        CoroutineScope(Dispatchers.IO).launch {
            instaParkRepository.getPosts()
                .onStart { _posts.postValue(Resource.Loading()) }
                .catch { msg-> _posts.postValue(Resource.Error(Throwable(msg)))}
                .collect { _posts.postValue(it) }
        }
    }
}
