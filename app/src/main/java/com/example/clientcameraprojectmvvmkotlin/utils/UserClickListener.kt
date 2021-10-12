package com.example.clientcameraprojectmvvmkotlin.utils

import android.view.View
import com.example.clientcameraprojectmvvmkotlin.model.User

interface UserClickListener {
    fun onUserClicked(view: View, position: Int)
}