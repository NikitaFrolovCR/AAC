package com.example.nikita.aac

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val userLiveData = UserLiveData()

    val isLoadingLiveData = MediatorLiveData<Boolean>().apply {
        this.addSource(userLiveData) { this.value = false }
    }

    fun loadUser(id: Long) {
        isLoadingLiveData.value = true
        userLiveData.loadUser(id)
    }
}