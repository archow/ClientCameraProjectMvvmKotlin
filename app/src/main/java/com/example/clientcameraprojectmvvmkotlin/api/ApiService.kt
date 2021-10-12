package com.example.clientcameraprojectmvvmkotlin.api

import com.example.clientcameraprojectmvvmkotlin.model.PictureResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //i have it as suspend because we will be using this inside a coroutine
    @GET("b852db38-d936-4880-b4ab-13361debe270")
    suspend fun getPictureResponse(): Response<PictureResponse>
}