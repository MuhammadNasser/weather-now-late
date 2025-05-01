package com.muhammad.dayforecast.presentation

import com.muhammad.core.model.local.DailyForecast

sealed interface ForecastUiState {
    object Loading : ForecastUiState
    data class Success(val data: List<DailyForecast>) : ForecastUiState
    data class Error(val message: String) : ForecastUiState
}