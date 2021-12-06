package com.veripark.instapark.data.repository

import com.resurrection.imkb.util.Resource
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.model.users.UsersModelItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface InstaParkRepository {
    suspend fun getUser(): Flow<Resource<List<UsersModelItem>>>
    suspend fun getxxx(): Flow<Resource<*>>
}