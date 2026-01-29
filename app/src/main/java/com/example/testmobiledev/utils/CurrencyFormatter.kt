package com.example.testmobiledev.utils

import java.text.NumberFormat
import java.util.Locale

object CurrencyFormatter {
    private val indonesiaLocale: Locale = Locale.Builder()
        .setLanguage("id")
        .setRegion("ID")
        .build()

    private val formatter: NumberFormat by lazy {
        NumberFormat.getCurrencyInstance(indonesiaLocale).apply {
            maximumFractionDigits = 0
        }
    }

    fun formatRupiah(amount: Double): String {
        val formatted = formatter.format(amount)
        return formatted.replace("Rp", "Rp. ")
    }
}