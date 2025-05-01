package com.muhammad.weathernowlater.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.muhammad.cityinput.presentation.CityInputScreen
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_CITY_INPUT
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_CURRENT_WEATHER
import com.muhammad.core.utils.ScreenRoutes.SCREEN_KEY_FORECAST

@Composable
fun WeatherNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SCREEN_KEY_CITY_INPUT
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
//            CurrentWeatherScreen(city)
        }
        composable(SCREEN_KEY_FORECAST) {
//            ForecastScreen()
        }
    }
}