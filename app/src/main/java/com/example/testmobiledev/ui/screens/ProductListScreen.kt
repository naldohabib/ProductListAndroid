package com.example.testmobiledev.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testmobiledev.ui.components.CheckoutPopup
import com.example.testmobiledev.ui.components.Footer
import com.example.testmobiledev.ui.components.Header
import com.example.testmobiledev.ui.components.Loader
import com.example.testmobiledev.ui.components.ProductItem
import com.example.testmobiledev.ui.components.SortMenu
import com.example.testmobiledev.ui.theme.grayLight
import com.example.testmobiledev.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {
    var showPopup by remember { mutableStateOf(false) }
    val selectedCount by remember { derivedStateOf { viewModel.products.count { it.quantity > 0 } } }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Header(productCount = selectedCount)

        // Product List
        if (viewModel.loading) {
            Loader()
        } else if (viewModel.error) {
            Text(
                "Error loading products",
                modifier = Modifier.padding(16.dp)
            )
        } else {
            SortMenu(viewModel)
            HorizontalDivider(thickness = 1.dp, color = grayLight)
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 8.dp)
            ) {
                items(viewModel.products) { product ->
                    ProductItem(
                        product = product,
                        onIncrease = { viewModel.increaseQuantity(product) },
                        onDecrease = { viewModel.decreaseQuantity(product) }
                    )
                }
            }
        }

        Footer(
            total = viewModel.total,
            onCheckout = { showPopup = true },
            onReset = { viewModel.resetCart() }
        )
    }

    // Checkout Popup
    if (showPopup) {
        CheckoutPopup(
            products = viewModel.products,
            total = viewModel.total,
            onClose = {
                showPopup = false
                viewModel.resetCart()
            }
        )
    }
}