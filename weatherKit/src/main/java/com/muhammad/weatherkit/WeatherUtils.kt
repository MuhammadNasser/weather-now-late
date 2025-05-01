package com.muhammad.weatherkit

import java.util.Locale


/**
 * Extension function to format a temperature value
 * according to the specified Temperature Units.
 *
 * Example:
 * 25.formatTemperature("metric") -> "25°C"
 * 77.formatTemperature("imperial") -> "77°F"
 *
 * @param units The [String] to format the temperature with.
 * @return A formatted temperature string.
 */
fun Int.formatTemperature(units: String): String {
    return "${this}${TemperatureUnits.fromString(units).symbol}"
}

/**
 * Extension function that maps a weather condition string to its corresponding icon resource.
 *
 * Uses [WeatherCondition.fromString] to determine the type of weather based on the string content,
 * then returns the associated drawable resource ID for that condition.
 *
 * Example:
 * ```
 * val iconRes = "clear sky".weatherConditionIcon() // returns R.drawable.ic_clear
 * ```
 *
 * @return The drawable resource ID representing the weather condition.
 */
fun String.weatherConditionIcon(): Int {
    return WeatherCondition.fromString(this.lowercase(Locale.ROOT)).iconRes
}