package com.resurrection.imkb.util

import com.veripark.instapark.util.Resource
import retrofit2.Response

suspend fun <T> getResourceByNetworkRequest(request: suspend () -> Response<T>): Resource<T> {
    try {
        val response = request()
        if (response.isSuccessful) {
            response.body()?.apply {
                return Resource.Success(this)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        return Resource.Error(e)
    }

    return Resource.Loading()
}

