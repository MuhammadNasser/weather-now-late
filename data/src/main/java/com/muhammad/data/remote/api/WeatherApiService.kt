package com.muhammad.data.remote.api

import com.muhammad.core.model.remote.CurrentWeatherResponse
import com.muhammad.core.model.remote.ForecastResponse
import com.muhammad.core.utils.NetworkConstants.FORECAST_BASE_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String, @Query("appid") apiKey: String, @Query("units") units: String
    ): CurrentWeatherResponse

    @GET(FORECAST_BASE_URL)
    suspend fun getDayForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String,
        @Query("exclude") exclude: String = "current,minutely,hourly,alerts"
    ): ForecastResponse
}