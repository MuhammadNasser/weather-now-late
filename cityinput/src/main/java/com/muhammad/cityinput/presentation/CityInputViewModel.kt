package com.muhammad.cityinput.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.cityinput.domain.GetRecentCitiesUseCase
import com.muhammad.cityinput.domain.SaveCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(
    private val saveCityUseCase: SaveCityUseCase,
    private val getRecentCitiesUseCase: GetRecentCitiesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CityInputState())
    val state: StateFlow<CityInputState> = _state

    init {
        loadRecentCities()
    }

    fun onCityNameChanged(newCity: String) {
        _state.update { it.copy(cityName = newCity) }
    }

    fun saveCity() {
        val city = state.value.cityName.trim()
        if (city.isNotEmpty()) {
            viewModelScope.launch {
                saveCityUseCase(city)
                loadRecentCities()
            }
        }
    }

    private fun loadRecentCities() {
        viewModelScope.launch {
            _state.update {
                it.copy(recentCities = getRecentCitiesUseCase())
            }
        }
    }
}