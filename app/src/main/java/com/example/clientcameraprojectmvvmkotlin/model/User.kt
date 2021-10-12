package com.example.clientcameraprojectmvvmkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
    @Expose
    val id: Int,
    @Expose
    val username: String?,
    @Expose
    @SerializedName("profile_picture_url")
    val profilePictureUrl: String?,
    @Expose
    @SerializedName("verified_status")
    val verifiedStatus: Int?,
    @Expose
    val url: String?,
    @Expose
    @SerializedName("full_name")
    val fullName: String?
)