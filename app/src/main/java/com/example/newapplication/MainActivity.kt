package com.example.newapplication

import ComposeMVVMTheme
import PostScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.activity.viewModels
import com.example.newapplication.viewmodel.PostViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContent{
            ComposeMVVMTheme{
                Surface(color=MaterialTheme.colors.background) {
                    PostScreen(viewModel)
                }
            }
        }
    }
}