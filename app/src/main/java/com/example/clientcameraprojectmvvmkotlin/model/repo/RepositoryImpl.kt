package com.example.clientcameraprojectmvvmkotlin.model.repo

import androidx.lifecycle.LiveData
import com.example.clientcameraprojectmvvmkotlin.api.ApiService
import com.example.clientcameraprojectmvvmkotlin.api.RetrofitClient
import com.example.clientcameraprojectmvvmkotlin.model.PictureResponse
import retrofit2.Response

class RepositoryImpl(): Repository {
    override suspend fun getPictureResponse(): Response<PictureResponse> {
        return RetrofitClient
            .getService(ApiService::class.java)
            .getPictureResponse()
    }
    //database
}