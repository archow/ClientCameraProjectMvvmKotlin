package com.example.clientcameraprojectmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clientcameraprojectmvvmkotlin.model.User
import com.example.clientcameraprojectmvvmkotlin.model.repo.Repository
import com.example.clientcameraprojectmvvmkotlin.model.repo.RepositoryImpl
import com.example.clientcameraprojectmvvmkotlin.utils.coroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(val repository: Repository): ViewModel() {
    //this is where we'll do our network call
    //..how do?
    //two things usually in our viewmodel:
    //repository instance
    //the data that we're keeping track of
    var userListLiveData: MutableLiveData<List<User?>> =
        MutableLiveData<List<User?>>()

    init {
        //this init block gets called when an instance of our UserViewModel
        //first gets created

    }

    //this will be our network call
    fun updateUserListLiveData() {
        //here we need some kind of threading method to make
        //our network call
        //easiest alternative to threads: Coroutines!
        //we'll use somethign called a scope for Corotuine;
        //the thing is, there are a few types of scopes:
        //CoroutineScope - lasts until the task inside the block is done
        //ViewmodelScope - lasts as long as the Viewmodel
        //GlobalScope - lasts for the entire app lifecycle
        //LifecycleScope - tied to the lifecycle of whichever activity
        //is in

        //once we choose the scope, we have to determine which builder
        //to use
        //the builder is called a Dispatcher
        //usually you want to use Main or IO dispatcher

        coroutine {
            //type in the block of code that will be executed
            //this is where we'll be making our network call
            val pictureResponseLd = repository.getPictureResponse()
            if (pictureResponseLd.isSuccessful) {
                pictureResponseLd.body()?.let {
                    //let's finally update our live data value here
                    //..how do?
                    val listOfUsers = it.data?.users
                    //postValue updates the value of our MutableLiveData
                    //setValue does the same thing
                    userListLiveData.postValue(listOfUsers)
                }
            } else {
                //error handling mechanism
            }
        }
    }
}