package com.example.studyhub.network

import retrofit2.Response
import retrofit2.http.GET
import com.example.studyhub.model.LoginResponse

interface ApiService {

    @GET("users/1")
    suspend fun loginDummy(): Response<LoginResponse>

}