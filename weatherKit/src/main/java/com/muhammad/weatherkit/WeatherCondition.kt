package com.muhammad.weatherkit

/**
 * Enum class representing different weather conditions,
 * each associated with a drawable resource icon.
 */
enum class WeatherCondition(val iconRes: Int) {
    CLEAR(R.drawable.ic_clear),
    CLOUDS(R.drawable.ic_cloud),
    RAIN(R.drawable.ic_rain),
    UNKNOWN(R.drawable.ic_unknown);

    companion object {
        /**
         * Maps a weather condition string to a [WeatherCondition] enum.
         * Defaults to [UNKNOWN] if the string does not match any known condition.
         *
         * @param condition The weather condition contains a string (e.g., "clear", "clouds", "rain", "haze").
         * @return The corresponding [WeatherCondition] enum.
         */
        fun fromString(condition: String): WeatherCondition {
            return when {
                condition.contains("clear") -> CLEAR
                condition.contains("clouds") -> CLOUDS
                condition.contains("rain") -> RAIN
                else -> UNKNOWN
            }
        }
    }
}