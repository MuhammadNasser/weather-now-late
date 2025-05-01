package com.muhammad.core.model.remote

data class ForecastResponse(
    val daily: List<DailyWeatherResponse>? = null
)

data class DailyWeatherResponse(
    val dt: Long? = null,
    val summary: String? = null,
    val temp: TemperatureResponse? = null,
    val weather: List<WeatherResponse>? = null
)

data class TemperatureResponse(
    val day: Double? = null,
    val min: Double? = null,
    val max: Double? = null,
    val night: Double? = null,
    val eve: Double? = null,
    val morn: Double? = null
)

data class WeatherResponse(
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null
)
