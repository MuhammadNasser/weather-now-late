package com.muhammad.weatherkit

/**
 * Represents the temperature unit with its symbol.
 * Can be either Celsius (°C) or Fahrenheit (°F).
 */
enum class TemperatureUnit(val symbol: String) {
    CELSIUS("°C"),
    FAHRENHEIT("°F")
}