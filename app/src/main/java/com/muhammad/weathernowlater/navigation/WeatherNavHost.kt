package com.muhammad.weathernowlater.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.muhammad.cityinput.presentation.CityInputScreen

@Composable
fun WeatherNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SCREEN_KEY_CITY_INPUT
    ) {
        composable(ScreenRoutes.SCREEN_KEY_CITY_INPUT) {
            CityInputScreen(onCitySelected = { city ->
                navController.navigate("${ScreenRoutes.SCREEN_KEY_CURRENT_WEATHER}/$city")
            })
        }
        composable(
            route = "${ScreenRoutes.SCREEN_KEY_CURRENT_WEATHER}/{city}",
            arguments = listOf(navArgument("city") { type = NavType.StringType })
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
//            CurrentWeatherScreen(city)
        }
        composable(ScreenRoutes.SCREEN_KEY_FORECAST) {
//            ForecastScreen()
        }
    }
}