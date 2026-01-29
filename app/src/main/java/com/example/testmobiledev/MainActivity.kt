package com.example.testmobiledev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.example.testmobiledev.ui.screens.ProductListScreen
import com.example.testmobiledev.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = remember { ProductViewModel() }
            ProductListScreen(viewModel = viewModel)
        }
    }
}