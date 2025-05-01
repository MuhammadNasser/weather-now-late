package com.muhammad.currentweather.presentation

import com.muhammad.core.model.local.CurrentWeather

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: CurrentWeather) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}