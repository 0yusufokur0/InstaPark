package com.veripark.instapark.data.remote

import com.veripark.instapark.data.model.photos.PhotoModel
import com.veripark.instapark.data.model.posts.PostModel
import com.veripark.instapark.data.model.users.UsersModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface InstaParkApiService {
    @GET("users")
    suspend fun getUser(): Response<UsersModel>

    @GET("posts")
    suspend fun getPosts(): Response<PostModel>

    @GET("photos")
    suspend fun getPhotos(): Response<PhotoModel>

/*
    https://jsonplaceholder.typicode.com/users/1
*/
}