package com.example.newapplication.data

import com.example.newapplication.model.PostResponse
import com.example.newapplication.service.RetrofitInstance


class PostRepository {
    private val postService = RetrofitInstance.postService

    suspend fun getPost(): PostResponse {
        return postService.getPost()
    }

    suspend fun getPosts(): List<PostResponse>{
        return postService.getPosts()
    }
}