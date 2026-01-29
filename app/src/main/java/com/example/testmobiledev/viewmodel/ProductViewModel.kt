package com.example.testmobiledev.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmobiledev.data.api.ApiClient
import com.example.testmobiledev.data.model.ProductModel
import kotlinx.coroutines.launch

enum class SortType { DEFAULT, HIGHEST_PRICE, LOWEST_PRICE, NAME }

class ProductViewModel : ViewModel() {

    var products by mutableStateOf<List<ProductModel>>(emptyList())
    var loading by mutableStateOf(true)
    var error by mutableStateOf(false)
    var total by mutableDoubleStateOf(0.0)
    var sortType by mutableStateOf(SortType.DEFAULT)

    init {
        fetchProduct()
    }

    private fun fetchProduct() {
        loading = true
        error = false
        viewModelScope.launch {
            try {
                val response = ApiClient.api.getProducts()
                products = response.products.map { apiProduct ->
                    ProductModel(
                        id = apiProduct.id,
                        title = apiProduct.title,
                        price = apiProduct.price,
                        stock = apiProduct.stock,
                        thumbnail = apiProduct.thumbnail
                    )
                }
                loading = false
            } catch (_: Exception) {
                error = true
                loading = false
            }
        }
    }

    fun increaseQuantity(product: ProductModel) {
        if (product.quantity < product.stock) {
            product.quantity++
            calculateTotal()
        }
    }

    fun decreaseQuantity(product: ProductModel) {
        if (product.quantity > 0) {
            product.quantity--
            calculateTotal()
        }
    }

    private fun calculateTotal() {
        total = products.sumOf { it.quantity * it.price }
    }

    fun resetCart() {
        products.forEach { it.quantity = 0 }
        calculateTotal()
    }

    fun sortProducts(type: SortType) {
        sortType = type
        products = when (type) {
            SortType.DEFAULT -> products
            SortType.HIGHEST_PRICE -> products.sortedByDescending { it.price }
            SortType.LOWEST_PRICE -> products.sortedBy { it.price }
            SortType.NAME -> products.sortedBy { it.title }
        }
    }
}