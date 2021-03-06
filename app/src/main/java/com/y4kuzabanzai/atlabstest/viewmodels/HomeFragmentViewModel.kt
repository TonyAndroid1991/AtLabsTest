package com.y4kuzabanzai.atlabstest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.y4kuzabanzai.atlabstest.repositories.AppRepository

class HomeFragmentViewModel : ViewModel() {

    val userName = MutableLiveData<String>()

    init {
        userName.value = ""
    }

    /**esto ver si no usar live data y ver si la response no success sacar de aqui otro toast*/
    val usernameLive = liveData {
        userName.value?.let { AppRepository().getUser(it).body().let { emit(it) } }
    }

    val userRepositories = liveData {
        userName.value?.let { AppRepository().getUserRepositories(it).body().let { emit(it) } }
    }


}