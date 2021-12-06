package com.veripark.instapark.data.remote

import com.veripark.instapark.data.model.users.UsersModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface InstaParkApiService {
    @GET("users")
    suspend fun getUser(): Response<UsersModel>

    @POST("users")
    suspend fun getxxxx(): Response<*>
}