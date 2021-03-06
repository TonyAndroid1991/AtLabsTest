package com.y4kuzabanzai.atlabstest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.y4kuzabanzai.atlabstest.models.user.User
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.repositories.AppRepository

class HomeFragmentViewModel : ViewModel() {

    val userName = MutableLiveData<String>()

    init {
        userName.value = ""
    }

    fun getUser(): LiveData<User?>? {
        if (userName.value != null) {
            return liveData {
                userName.value?.let<String, Unit> { AppRepository().getUser(it).body().let { emit(it) } }
            }
        }
        return null
    }

    fun getUserRepositories(): LiveData<UserRepositories?>? {
        if (userName.value != null) {
            return liveData {
                userName.value?.let<String, Unit> {
                    AppRepository().getUserRepositories(it).body().let { emit(it) }
                }
            }
        }
        return null
    }
}