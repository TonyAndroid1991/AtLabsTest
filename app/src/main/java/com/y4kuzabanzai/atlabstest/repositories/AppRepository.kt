package com.y4kuzabanzai.atlabstest.repositories

import com.y4kuzabanzai.atlabstest.models.user.User
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.retrofit.RetrofitInstance
import retrofit2.Response

class AppRepository {

    suspend fun getUser(userName: String): Response<User> {
        return RetrofitInstance.apiService.getUser(userName)
    }

    suspend fun getUserRepositories(userName: String): Response<UserRepositories> {
        return RetrofitInstance.apiService.getUserRepositories(userName)
    }
}