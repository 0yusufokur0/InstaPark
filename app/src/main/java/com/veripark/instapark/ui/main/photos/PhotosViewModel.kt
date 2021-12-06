package com.veripark.instapark.ui.main.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veripark.instapark.data.model.photos.PhotoModel
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
class PhotosViewModel @Inject constructor(private val instaParkRepository: InstaParkRepository) : ViewModel() {

    private val _photos = MutableLiveData<Resource<PhotoModel>>()
    val photos : LiveData<Resource<PhotoModel>> = _photos

    fun getPhotos() {
        CoroutineScope(Dispatchers.IO).launch {
            instaParkRepository.getPhotos()
                .onStart { _photos.postValue(Resource.Loading()) }
                .catch { msg -> _photos.postValue(Resource.Error(Throwable(msg))) }
                .collect { _photos.postValue(it)
                println(it)
                }
        }
    }
}