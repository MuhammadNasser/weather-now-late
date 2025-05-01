package com.muhammad.core.model.query

data class CurrentWeatherQuery(
    val cityName: String,
    val units:String = "metric"
)