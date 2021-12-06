package com.veripark.instapark.ui.main.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veripark.instapark.util.Resource
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.repository.InstaParkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val instaParkRepository: InstaParkRepository) : ViewModel() {

    private val _users = MutableLiveData<Resource<UsersModel>>()
    val users : LiveData<Resource<UsersModel>> = _users

    fun getUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            instaParkRepository.getUser()
                .onStart { _users.postValue(Resource.Loading()) }
                .catch { msg-> _users.postValue(Resource.Error(Throwable(msg)))}
                .collect { _users.postValue(it)}
        }
    }
}