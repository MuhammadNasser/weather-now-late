package com.muhammad.cityinput.domain

import com.muhammad.cityinput.data.repository.CityRepository
import javax.inject.Inject

class GetRecentCitiesUseCase @Inject constructor(
    private val repo: CityRepository
) {
    suspend operator fun invoke(): List<String> = repo.getRecentCities()
}