package com.example.newapplication.service


import com.example.newapplication.model.PostResponse
import retrofit2.http.GET

interface PostService {
    @GET("posts/1")
    suspend fun getPost(): PostResponse

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>
}