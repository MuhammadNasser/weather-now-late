package com.muhammad.cityinput.domain

import javax.inject.Inject

class SaveCityUseCase @Inject constructor(
    private val repo: com.muhammad.core.repository.CityInputRepository
) {
    suspend operator fun invoke(cityName: String) = repo.saveCity(cityName)
}