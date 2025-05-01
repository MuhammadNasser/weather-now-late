package com.muhammad.core.repository

import com.muhammad.core.model.query.CurrentWeatherQuery
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.ForecastResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(currentWeatherQuery: CurrentWeatherQuery): CurrentWeatherResponse
    suspend fun getDayForecast(dayForecastQuery: DayForecastQuery): ForecastResponse
}