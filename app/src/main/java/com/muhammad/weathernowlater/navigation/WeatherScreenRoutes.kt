package com.muhammad.weathernowlater.navigation

sealed class WeatherScreenRoutes(val route: String) {
    data object CityInput : WeatherScreenRoutes("city_input")
    data object CurrentWeather : WeatherScreenRoutes("current_weather/{city}") {
        fun createRoute(city: String) = "current_weather/$city"
    }
    data object Forecast : WeatherScreenRoutes("forecast/{city}/{lat}/{lon}/{units}") {
        fun createRoute(city: String, lat: Double, lon: Double, units: String) =
            "forecast/$city/$lat/$lon/$units"
    }
}