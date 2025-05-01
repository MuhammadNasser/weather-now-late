package com.muhammad.core.model.query

data class DayForecastQuery(
    val cityName: String,
    val lat: Double,
    val lon: Double,
    val units: String = "metric"
)