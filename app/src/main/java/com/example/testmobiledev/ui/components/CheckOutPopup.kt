package com.example.testmobiledev.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.data.model.ProductModel
import com.example.testmobiledev.ui.theme.grayDark
import com.example.testmobiledev.ui.theme.neutral90
import com.example.testmobiledev.utils.CurrencyFormatter.formatRupiah

@Composable
fun CheckoutPopup(
    products: List<ProductModel>,
    total: Double,
    onClose: () -> Unit
) {
    val totalProducts = products.sumOf { it.quantity }
    val formattedTotal = formatRupiah(total)

    AlertDialog(
        onDismissRequest = onClose,
        title = {
            Text(
                text = "Success",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = neutral90,
            )
        },

        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "You have successfully purchased $totalProducts products " +
                            "with a total of $formattedTotal. " +
                            "Click Close to buy another products.",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = neutral90
                )
            }
        },

        confirmButton = {
            Button(
                onClick = onClose,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = grayDark
                )
            ) {
                Text("Close")
            }
        },
    )
}