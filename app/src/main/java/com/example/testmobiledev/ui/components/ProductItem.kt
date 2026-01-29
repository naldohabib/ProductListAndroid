package com.example.testmobiledev.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.data.model.ProductModel
import com.example.testmobiledev.ui.theme.grayDark
import com.example.testmobiledev.ui.theme.grayExtraLight
import com.example.testmobiledev.ui.theme.grayLight
import com.example.testmobiledev.ui.theme.grayMedium
import com.example.testmobiledev.ui.theme.grayNeutral
import com.example.testmobiledev.utils.CurrencyFormatter.formatRupiah

@Composable
fun ProductItem(
    product: ProductModel,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    val price = formatRupiah(product.price)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                start = 20.dp,
                end = 20.dp,
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    product.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    color = grayDark,
                )
                Text(
                    price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    color = grayMedium,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(grayExtraLight, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, grayLight, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
                Button(
                    onClick = onDecrease,
                    enabled = product.quantity > 0,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(32.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        disabledContainerColor = grayNeutral,
                        disabledContentColor = grayNeutral
                    )
                ) {
                    Text("-", fontSize = 18.sp, color = Color.White)
                }

                Text(
                    text = "${product.quantity}",
                    modifier = Modifier.padding(horizontal = 12.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400
                )

                Button(
                    onClick = onIncrease,
                    enabled = product.quantity < product.stock,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(32.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        disabledContainerColor = grayNeutral,
                        disabledContentColor = grayNeutral
                    )
                ) {
                    Text("+", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}