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
import com.example.newapplication.view.DailyActivityScreen
import com.example.newapplication.viewmodel.DailyActivityViewModel
import com.example.newapplication.viewmodel.PostViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: DailyActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContent{
            ComposeMVVMTheme{
                Surface(modifier = Modifier.fillMaxSize() , color = MaterialTheme.colors.background) {
                    DailyActivityScreen(viewModel)
                }
            }
        }
    }
}