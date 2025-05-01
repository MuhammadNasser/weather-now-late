package com.muhammad.data.mapper

import com.muhammad.core.model.local.CurrentWeather
import com.muhammad.core.model.remote.CurrentWeatherResponse

fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        cityName = name.orEmpty(),
        temp = main?.temp?.toInt() ?: 0,
        description = weather?.firstOrNull()?.description.orEmpty(),
        condition = weather?.firstOrNull()?.main.orEmpty(),
        feelsLike = main?.feelsLike?.toInt() ?: 0,
        humidity = main?.humidity ?: 0,
        pressure = main?.pressure ?: 0
    )
}