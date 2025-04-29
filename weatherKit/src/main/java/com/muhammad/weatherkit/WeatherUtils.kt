package com.muhammad.weatherkit


/**
 * Extension function to format a temperature value
 * according to the specified [TemperatureUnit].
 *
 * Example:
 * 25.0.formatTemperature() -> "25°C"
 * 77.0.formatTemperature(TemperatureUnit.FAHRENHEIT) -> "77°F"
 *
 * @param unit The [TemperatureUnit] to format the temperature with. Defaults to [TemperatureUnit.CELSIUS].
 * @return A formatted temperature string.
 */
fun Double.formatTemperature(unit: TemperatureUnit = TemperatureUnit.CELSIUS): String {
    return "${this.toInt()}${unit.symbol}"
}