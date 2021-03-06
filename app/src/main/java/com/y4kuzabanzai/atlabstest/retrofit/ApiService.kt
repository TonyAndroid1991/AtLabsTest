package com.y4kuzabanzai.atlabstest.retrofit

import com.y4kuzabanzai.atlabstest.models.user.User
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users/{user_name}")
    suspend fun getUser(@Path("user_name") userName: String): Response<User>

    @GET("/users/{user_name}/repos")
    suspend fun getUserRepositories(@Path("user_name") userName: String): Response<UserRepositories>

}