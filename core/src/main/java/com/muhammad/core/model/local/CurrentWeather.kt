package com.muhammad.core.model.local

data class CurrentWeather(
    val cityName: String,
    val temp: Int,
    val feelsLike: Int,
    val humidity: Int,
    val pressure: Int,
    val condition: String,
    val description: String
)