package com.muhammad.cityinput.presentation

data class CityInputState(
    val cityName: String = "",
    val recentCities: List<String> = emptyList()
)