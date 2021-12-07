package com.veripark.instapark.ui.main.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.model.users.UsersModelItem
import com.veripark.instapark.data.repository.InstaParkRepository
import com.veripark.instapark.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val instaParkRepository: InstaParkRepository) : ViewModel(){
private val _user = MutableLiveData<Resource<UsersModelItem>>()
    val user : LiveData<Resource<UsersModelItem>> = _user

    fun getUsers(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            instaParkRepository.getUser(id)
                .onStart { _user.postValue(Resource.Loading()) }
                .catch { msg-> _user.postValue(Resource.Error(Throwable(msg)))}
                .collect { _user.postValue(it)}
        }
    }
}