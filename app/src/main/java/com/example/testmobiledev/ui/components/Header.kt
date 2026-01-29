package com.example.testmobiledev.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.R
import com.example.testmobiledev.ui.theme.*

@Composable
fun Header(productCount: Int = 0) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = redDark,
                shape = RoundedCornerShape(
                    bottomStart = 24.dp, bottomEnd = 24.dp
                )
            )
            .padding(
                top = 32.dp,
                bottom = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_mobile),
                contentDescription = "Device Icon",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Product List",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700
                )

                if (productCount > 0) {
                    Text(
                        text = "$productCount product",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }
    }
}