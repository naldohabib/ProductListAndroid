package com.example.testmobiledev.data.model

import androidx.compose.runtime.*

data class ProductModel(
    val id: Int,
    val title: String,
    val price: Double,
    val stock: Int,
    val thumbnail: String,
) {
    var quantity by mutableIntStateOf(0)
}