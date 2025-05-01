package com.muhammad.weathernowlater.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.muhammad.cityinput.presentation.CityInputScreen
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_CITY_INPUT
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_CURRENT_WEATHER
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_FORECAST
import com.muhammad.currentweather.presentation.CurrentWeatherScreen
import com.muhammad.currentweather.presentation.CurrentWeatherViewModel
import com.muhammad.dayforecast.presentation.ForecastScreen
import com.muhammad.dayforecast.presentation.ForecastViewModel

@Composable
fun WeatherNavHost(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = SCREEN_KEY_CITY_INPUT
    ) {
        composable(SCREEN_KEY_CITY_INPUT) {
            CityInputScreen(onCitySelected = { city ->
                navController.navigate("$SCREEN_KEY_CURRENT_WEATHER/$city")
            })
        }
        composable(
            route = "${SCREEN_KEY_CURRENT_WEATHER}/{city}",
            arguments = listOf(navArgument("city") { type = NavType.StringType })
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
            val viewModel: CurrentWeatherViewModel = hiltViewModel(backStackEntry)

            CurrentWeatherScreen(city, viewModel, onForecastClick = { dayForecastQuery ->
                navController.navigate("$SCREEN_KEY_FORECAST/${dayForecastQuery.cityName}/${dayForecastQuery.lat}/${dayForecastQuery.lon}/${dayForecastQuery.units}")
            }, onBackClick = {
                navController.popBackStack()
            })
        }
        composable(route = "$SCREEN_KEY_FORECAST/{city}/{lat}/{lon}/{units}") { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city").orEmpty()
            val lat = backStackEntry.arguments?.getString("lat")?.toDouble() ?: 0.0
            val lon = backStackEntry.arguments?.getString("lon")?.toDouble() ?: 0.0
            val units = backStackEntry.arguments?.getString("units").orEmpty()
            val viewModel: ForecastViewModel = hiltViewModel(backStackEntry)
            ForecastScreen(viewModel,city, lat, lon, units,  onBack = {
                navController.popBackStack()
            })
        }
    }
}