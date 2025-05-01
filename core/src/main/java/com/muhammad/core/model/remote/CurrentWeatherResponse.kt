package com.muhammad.core.model.remote

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("main")
    val main: MainInfo? = null,

    @SerializedName("weather")
    val weather: List<WeatherInfo>? = null
)

data class MainInfo(
    @SerializedName("temp")
    val temp: Double? = null,

    @SerializedName("feels_like")
    val feelsLike: Double? = null,

    @SerializedName("pressure")
    val pressure: Int? = null,

    @SerializedName("humidity")
    val humidity: Int? = null
)

data class WeatherInfo(
    @SerializedName("main")
    val main: String? = null,

    @SerializedName("description")
    val description: String? = null,
)