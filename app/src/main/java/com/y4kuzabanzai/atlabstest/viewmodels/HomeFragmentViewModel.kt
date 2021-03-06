package com.y4kuzabanzai.atlabstest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.y4kuzabanzai.atlabstest.models.userindetail.UserInDetail
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.repositories.AppRepository

class HomeFragmentViewModel : ViewModel() {

    val userName = MutableLiveData<String>()

    init {
        userName.value = ""
    }

    fun getUser(): LiveData<UserInDetail?>? {
        if (userName.value != null) {
            val user = liveData {
                userName.value?.let { AppRepository().getUser(it).body().let { emit(it) } }
            }
            return user
        }
        return null
    }


    fun getUserRepositories(): LiveData<UserRepositories?>? {
        if (userName.value != null) {
            val userRepositories = liveData {
                userName.value?.let {
                    AppRepository().getUserRepositories(it).body().let { emit(it) }
                }
            }
            return userRepositories
        }
        return null
    }

}