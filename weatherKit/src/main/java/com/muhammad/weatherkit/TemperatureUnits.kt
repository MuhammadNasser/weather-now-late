package com.muhammad.weatherkit

/**
 * Represents the temperature unit with its symbol.
 * Can be either Celsius (°C) or Fahrenheit (°F).
 */
enum class TemperatureUnits(val symbol: String) {
    CELSIUS("°C"),
    FAHRENHEIT("°F");

    companion object {
        fun fromString(unit: String): TemperatureUnits {
            return when (unit) {
                "metric" -> CELSIUS
                "imperial" -> FAHRENHEIT
                else -> CELSIUS
            }
        }
    }
}