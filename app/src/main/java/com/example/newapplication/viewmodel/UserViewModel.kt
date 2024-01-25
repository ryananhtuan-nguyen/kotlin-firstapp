package com.example.newapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapplication.data.UserRepository
import com.example.newapplication.model.UserResponse
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _user = MutableLiveData<UserResponse>()

    val user: LiveData<UserResponse> = _user

    fun fetchUser(){
        viewModelScope.launch {
            try{
                val user = repository.getUsers()
                _user.value = user
                Log.e("Fetch User", _user.value.toString())
            }catch(e: Exception){
                Log.e("Fetch user", e.message.toString())
            }
        }
    }

}