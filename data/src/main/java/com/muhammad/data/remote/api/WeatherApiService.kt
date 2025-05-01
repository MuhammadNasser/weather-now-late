package com.muhammad.data.remote.api

import com.muhammad.core.model.remote.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): CurrentWeatherResponse
}