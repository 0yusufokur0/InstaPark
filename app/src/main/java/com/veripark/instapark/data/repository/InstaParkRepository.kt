package com.veripark.instapark.data.repository

import com.veripark.instapark.data.model.photos.PhotoModel
import com.veripark.instapark.data.model.posts.PostModel
import com.veripark.instapark.util.Resource
import com.veripark.instapark.data.model.users.UsersModel
import com.veripark.instapark.data.model.users.UsersModelItem
import kotlinx.coroutines.flow.Flow

interface InstaParkRepository {
    suspend fun getUsers(): Flow<Resource<UsersModel>>
    suspend fun getUser(id:String): Flow<Resource<UsersModelItem>>
    suspend fun getPosts(): Flow<Resource<PostModel>>
    suspend fun getPhotos(): Flow<Resource<PhotoModel>>

}