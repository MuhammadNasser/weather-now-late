package com.muhammad.cityinput.domain

import javax.inject.Inject

class GetRecentCitiesUseCase @Inject constructor(
    private val repo: com.muhammad.core.repository.CityInputRepository
) {
    suspend operator fun invoke(): List<String> = repo.getRecentCities()
}