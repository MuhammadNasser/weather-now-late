package com.muhammad.cityinput.domain

import com.muhammad.cityinput.data.repository.CityRepository
import javax.inject.Inject

class SaveCityUseCase @Inject constructor(
    private val repo: CityRepository
) {
    suspend operator fun invoke(cityName: String) = repo.saveCity(cityName)
}