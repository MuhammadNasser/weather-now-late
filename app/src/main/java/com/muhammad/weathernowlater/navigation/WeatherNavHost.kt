package com.muhammad.weathernowlater.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.muhammad.cityinput.presentation.CityInputScreen
import com.muhammad.currentweather.presentation.CurrentWeatherScreen
import com.muhammad.currentweather.presentation.CurrentWeatherViewModel
import com.muhammad.dayforecast.presentation.ForecastScreen
import com.muhammad.dayforecast.presentation.ForecastViewModel

@Composable
fun WeatherNavHost(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = WeatherScreenRoutes.CityInput.route
    ) {
        composable(WeatherScreenRoutes.CityInput.route) {
            CityInputScreen(onCitySelected = { city ->
                navController.navigate(WeatherScreenRoutes.CurrentWeather.createRoute(city))
            })
        }
        composable(
            route = WeatherScreenRoutes.CurrentWeather.route,
            arguments = listOf(navArgument("city") { type = NavType.StringType })
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
            val viewModel: CurrentWeatherViewModel = hiltViewModel(backStackEntry)

            CurrentWeatherScreen(city, viewModel, onForecastClick = { dayForecastQuery ->
                navController.navigate(
                    WeatherScreenRoutes.Forecast.createRoute(
                        city,
                        dayForecastQuery.lat,
                        dayForecastQuery.lon,
                        dayForecastQuery.units
                    )
                )
            }, onBackClick = {
                navController.popBackStack()
            })
        }
        composable(route = WeatherScreenRoutes.Forecast.route) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city").orEmpty()
            val lat = backStackEntry.arguments?.getString("lat")?.toDouble() ?: 0.0
            val lon = backStackEntry.arguments?.getString("lon")?.toDouble() ?: 0.0
            val units = backStackEntry.arguments?.getString("units").orEmpty()
            val viewModel: ForecastViewModel = hiltViewModel(backStackEntry)
            ForecastScreen(viewModel, city, lat, lon, units, onBack = {
                navController.popBackStack()
            })
        }
    }
}