package com.veripark.instapark.data.repository

import com.resurrection.imkb.util.Resource
import com.resurrection.imkb.util.getResourceByDatabaseRequest
import com.resurrection.imkb.util.getResourceByNetworkRequest
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.remote.InstaParkApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InstaParkRepositoryImpl @Inject constructor(private val instaParkApiService: InstaParkApiService)
    : InstaParkRepository {


    override suspend fun getUser(): kotlinx.coroutines.flow.Flow<Resource<UsersModel>> = flow {
            emit(getResourceByNetworkRequest { instaParkApiService.getUser() })
        }

    override suspend fun getxxx(): Flow<Resource<*>> = flow {
        emit(getResourceByNetworkRequest { instaParkApiService.getxxxx() })
    }


}