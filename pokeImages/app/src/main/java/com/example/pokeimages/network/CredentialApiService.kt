package com.example.pokeimages.network

import com.example.pokeimages.data_class.LoginRequest
import com.example.pokeimages.data_class.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CredentialApiService {
    @Headers(
"x-api-key: reqres-free-v1",
        "Content-Type: application/json"
    )
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest) : LoginResponse
}