package com.example.newapplication

import ComposeMVVMTheme
import UserScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newapplication.viewmodel.UserViewModel
import androidx.activity.viewModels


class MainActivity : ComponentActivity() {
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContent{
            ComposeMVVMTheme{
                Surface(modifier = Modifier.fillMaxSize(), color=MaterialTheme.colors.background) {
                    UserScreen(viewModel)
                }
            }
        }
    }
}