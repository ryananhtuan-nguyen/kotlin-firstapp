package com.example.newapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapplication.data.PostRepository
import com.example.newapplication.model.PostResponse
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _post = MutableLiveData<PostResponse>()
    private val _posts = MutableLiveData<List<PostResponse>>()

    val post: LiveData<PostResponse> = _post

    val posts: LiveData<List<PostResponse>> = _posts

    fun getPost(){
        viewModelScope.launch {
            try{
                val post = repository.getPost()
                _post.value = post
                Log.e("Fetch Posts", _post.value.toString())
            }catch(e: Exception){
                Log.e("Fetch posts", e.message.toString())
            }
        }
    }

    fun getPosts(){
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _posts.value = posts
                Log.e("Fetch all posts", _post.value.toString())

            }catch(e:Exception){
                Log.e("Fetch all posts", e.message.toString())
            }
        }
    }

}