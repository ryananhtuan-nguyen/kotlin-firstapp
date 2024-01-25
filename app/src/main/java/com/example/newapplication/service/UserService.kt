package com.example.newapplication.service

import com.example.newapplication.model.UserResponse
import retrofit2.http.GET
interface UserService {
    @GET("users")
    suspend fun getUser(): UserResponse
}