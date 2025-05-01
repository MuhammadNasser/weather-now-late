package com.muhammad.core.model.local

data class CurrentWeather(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val cityName: String = "",
    val temp: Int = 0,
    val feelsLike: Int = 0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val condition: String = "",
    val description: String = ""
)