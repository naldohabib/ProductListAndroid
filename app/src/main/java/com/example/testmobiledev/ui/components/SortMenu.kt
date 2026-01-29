package com.example.testmobiledev.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmobiledev.ui.theme.grayDark
import com.example.testmobiledev.ui.theme.grayExtraLight
import com.example.testmobiledev.ui.theme.grayLight
import com.example.testmobiledev.viewmodel.ProductViewModel
import com.example.testmobiledev.viewmodel.SortType

@Composable
fun SortMenu(viewModel: ProductViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val selectedCount by remember { derivedStateOf { viewModel.products.count { it.quantity > 0 } } }
    val sortText = when (viewModel.sortType) {
        SortType.DEFAULT -> "Default"
        SortType.HIGHEST_PRICE -> "Highest Price"
        SortType.LOWEST_PRICE -> "Lowest Price"
        SortType.NAME -> "Name"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 32.dp,
                bottom = 23.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Sort,
                contentDescription = "Filter"
            )
            Spacer(Modifier.width(4.dp))
            Text("Sort by:", fontSize = 16.sp, fontWeight = FontWeight.W400, color = grayDark)
        }

        Box {
            val enabled = selectedCount > 0
            OutlinedButton(
                onClick = { if (enabled) expanded = true },
                enabled = enabled,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, grayLight),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = grayExtraLight,
                    contentColor = grayDark,
                    disabledContainerColor = grayExtraLight,
                    disabledContentColor = grayDark,
                )
            ) {
                Text(sortText, fontSize = 14.sp, fontWeight = FontWeight.W700, color = grayDark)
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Dropdown"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = { viewModel.sortProducts(SortType.DEFAULT); expanded = false },
                    text = {
                        Text(
                            "Default",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = grayDark,
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = { viewModel.sortProducts(SortType.HIGHEST_PRICE); expanded = false },
                    text = {
                        Text(
                            "Highest Price", fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = grayDark,
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = { viewModel.sortProducts(SortType.LOWEST_PRICE); expanded = false },
                    text = {
                        Text(
                            "Lowest Price", fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = grayDark,
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = { viewModel.sortProducts(SortType.NAME); expanded = false },
                    text = {
                        Text(
                            "Name", fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = grayDark,
                        )
                    }
                )
            }
        }
    }
}