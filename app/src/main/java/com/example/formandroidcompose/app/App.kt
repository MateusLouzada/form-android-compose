package com.example.formandroidcompose.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.formandroidcompose.screens.Home
import com.example.formandroidcompose.screens.SignUpScreen

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        SignUpScreen()
        //Home()
    }
}