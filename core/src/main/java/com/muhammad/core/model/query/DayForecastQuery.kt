package com.muhammad.core.model.query

data class DayForecastQuery(
    val cityName: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val units: String = "metric"
)