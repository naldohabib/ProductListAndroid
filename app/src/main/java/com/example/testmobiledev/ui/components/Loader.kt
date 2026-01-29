package com.example.testmobiledev.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.R
import com.example.testmobiledev.ui.theme.grayDark
import com.example.testmobiledev.ui.theme.grayMedium

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_mobile),
            contentDescription = "Device Icon",
            tint = grayDark,
            modifier = Modifier.size(75.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Loading Product Data",
            fontSize = 20.sp,
            color = grayDark,
            fontWeight = FontWeight.W700,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Please wait...",
            fontSize = 16.sp,
            color = grayMedium,
            fontWeight = FontWeight.W400,
        )
    }
}