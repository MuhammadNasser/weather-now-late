package com.muhammad.weatherkit

/**
 * Enum class representing different weather conditions,
 * each associated with a drawable resource icon.
 */
enum class WeatherCondition(val iconRes: Int) {
    SUNNY(R.drawable.ic_sunny),
    CLOUDY(R.drawable.ic_cloudy),
    RAINY(R.drawable.ic_rainy),
    UNKNOWN(R.drawable.ic_unknown)

    companion object {
        /**
         * Maps a weather condition string to a [WeatherCondition] enum.
         * Defaults to [UNKNOWN] if the string does not match any known condition.
         *
         * @param condition The weather condition as a string (e.g., "sunny", "cloudy", "rainy").
         * @return The corresponding [WeatherCondition] enum.
         */
        fun fromString(condition: String): WeatherCondition {
            return when (condition.lowercase()) {
                "sunny" -> SUNNY
                "cloudy" -> CLOUDY
                "rainy" -> RAINY
                else -> UNKNOWN
            }
        }
    }
}