package com.muhammad.dayforecast.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.core.model.query.DayForecastQuery
import com.muhammad.dayforecast.domain.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {

    private val _forecastState = MutableStateFlow<ForecastUiState>(ForecastUiState.Loading)
    val forecastState: StateFlow<ForecastUiState> = _forecastState

    fun getForecast(city: String, lat: Double, lon: Double, units: String = "metric") {
        _forecastState.value = ForecastUiState.Loading
        viewModelScope.launch {
            val result = getForecastUseCase(DayForecastQuery(city, lat, lon, units))
            _forecastState.value = result.fold(
                onSuccess = { ForecastUiState.Success(it) },
                onFailure = { ForecastUiState.Error(it.message ?: "Unknown error") }
            )
        }
    }
}