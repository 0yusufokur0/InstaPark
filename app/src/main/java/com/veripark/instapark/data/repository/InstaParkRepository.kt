package com.veripark.instapark.data.repository

import com.veripark.instapark.util.Resource
import com.veripark.instapark.data.model.users.UsersModel
import kotlinx.coroutines.flow.Flow

interface InstaParkRepository {
    suspend fun getUser(): Flow<Resource<UsersModel>>

}