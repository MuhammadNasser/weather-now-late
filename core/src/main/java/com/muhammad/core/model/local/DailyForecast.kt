package com.muhammad.core.model.local

data class DailyForecast(
    val date: String = "",
    val summary: String = "",
    val temp: String = "",
    val condition: String = "",
    val description: String = "",
    val icon: String = ""
)