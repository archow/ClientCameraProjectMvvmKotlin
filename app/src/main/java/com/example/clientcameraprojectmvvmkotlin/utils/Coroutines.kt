package com.example.clientcameraprojectmvvmkotlin.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//lets make a higher order function to launch a coroutine
fun coroutine(
    networkCall: suspend () -> Unit
) {
    CoroutineScope(Dispatchers.Main).launch {
        networkCall()
    }
}