package com.y4kuzabanzai.atlabstest.retrofit

import com.y4kuzabanzai.atlabstest.models.userindetail.UserInDetail
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositoriesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

//    @GET("/users")
//    suspend fun getAllUsers(): Response<ArrayList<FirstLookUserItem>>

    @GET("/users/{user_name}")
    suspend fun getUser(@Path("user_name") userName: String): Response<UserInDetail>

    @GET("/users/{user_name}/repos")
    suspend fun getUserRepositories(@Path("user_name") userName: String): Response<UserRepositories>

//    @GET("/users/{user_name}/repos")
//    suspend fun getUserRepositories(@Path("user_name") userName: String): Response<ArrayList<UserRepositoriesItem>>
}