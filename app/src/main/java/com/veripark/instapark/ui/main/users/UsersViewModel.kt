package com.veripark.instapark.ui.main.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
public class UsersViewModel @Inject constructor(private val instaParkRepository: InstaParkRepository) : ViewModel() {

    fun printUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            instaParkRepository.getxxx()
                .onStart {
                    println("loadinggg")
                }
                .catch {
                    println("errorr")
                }
                .collect {
                    println(it.data)
                    println(it.data)
                }
        }

    }
}