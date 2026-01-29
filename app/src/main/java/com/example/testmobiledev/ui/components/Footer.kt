package com.example.testmobiledev.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.ui.theme.grayDark
import com.example.testmobiledev.ui.theme.grayNeutral
import com.example.testmobiledev.ui.theme.neutral50
import com.example.testmobiledev.ui.theme.neutral90
import com.example.testmobiledev.utils.CurrencyFormatter.formatRupiah

@Composable
fun Footer(total: Double, onCheckout: () -> Unit, onReset: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val price = formatRupiah(total)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = neutral90
                )

                Text(
                    text = price,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = neutral90
                )
            }

            Spacer(modifier = Modifier.height(17.dp))

            ElevatedButton(
                onClick = onCheckout,
                enabled = total > 0,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = grayDark,
                    disabledContainerColor = grayNeutral,
                    contentColor = neutral50,
                    disabledContentColor = neutral50
                ),
            ) {
                Text("Checkout")
            }

            if (total > 0) {
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = onReset,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = grayDark
                    ),
                    border = BorderStroke(2.dp, grayDark),
                ) {
                    Text("Reset")
                }
            }
        }
    }
}