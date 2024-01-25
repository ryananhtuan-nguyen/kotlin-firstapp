package com.example.newapplication.data

import com.example.newapplication.model.UserResponse
import com.example.newapplication.service.RetrofitInstance
import com.example.newapplication.service.RetrofitInstance.userService


class UserRepository {
    private val userViewModel = RetrofitInstance.userService

    suspend fun getUsers(): UserResponse {
        return userService.getUser()
    }
}