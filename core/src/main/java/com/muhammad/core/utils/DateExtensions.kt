package com.muhammad.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedDate(): String {
    val date = Date(this * 1000)
    val sdf = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
    return sdf.format(date)
}