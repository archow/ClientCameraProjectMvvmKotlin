package com.example.clientcameraprojectmvvmkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clientcameraprojectmvvmkotlin.model.repo.Repository

class UserViewModelFactory(var repository: Repository) :
        ViewModelProvider.Factory{
    var sentences: String? = null

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}