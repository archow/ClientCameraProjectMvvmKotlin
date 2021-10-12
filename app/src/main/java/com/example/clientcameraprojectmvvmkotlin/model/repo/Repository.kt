package com.example.clientcameraprojectmvvmkotlin.model.repo

import com.example.clientcameraprojectmvvmkotlin.model.PictureResponse
import retrofit2.Response

interface Repository {
    suspend fun getPictureResponse(): Response<PictureResponse>
}