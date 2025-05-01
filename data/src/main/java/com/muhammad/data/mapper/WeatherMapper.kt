package com.muhammad.data.mapper

import com.muhammad.core.model.local.CurrentWeather
import com.muhammad.core.model.local.DailyForecast
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.DailyWeatherResponse
import com.muhammad.core.utils.NetworkConstants.LOAD_ICON_URL
import com.muhammad.core.utils.toFormattedDate

fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        lat = coordinates?.latitude ?: 0.0,
        lon = coordinates?.longitude ?: 0.0,
        cityName = name.orEmpty(),
        temp = main?.temp?.toInt() ?: 0,
        description = weather?.firstOrNull()?.description.orEmpty(),
        condition = weather?.firstOrNull()?.main.orEmpty(),
        feelsLike = main?.feelsLike?.toInt() ?: 0,
        humidity = main?.humidity ?: 0,
        pressure = main?.pressure ?: 0
    )
}

fun DailyWeatherResponse.toDailyWeather(): DailyForecast {
    return DailyForecast(
        date = dt?.toFormattedDate().orEmpty(),
        summary = summary.orEmpty(),
        temp = "${temp?.max?.toInt() ?: 0}° / ${temp?.min?.toInt() ?: 0}°",
        description = weather?.firstOrNull()?.description.orEmpty(),
        condition = weather?.firstOrNull()?.main.orEmpty(),
        icon = "$LOAD_ICON_URL${weather?.firstOrNull()?.icon.orEmpty()}@2x.png"
    )
}