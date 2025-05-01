package com.muhammad.currentweather.presentation

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.muhammad.core.model.query.DayForecastQuery

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeatherScreen(
    cityName: String,
    viewModel: CurrentWeatherViewModel,
    onForecastClick: (dayForecastQuery: DayForecastQuery) -> Unit,
    onBackClick: () -> Unit
) {
    val weatherState by viewModel.weatherState.collectAsState()
    var units by remember { mutableStateOf("metric") }

    val context = LocalContext.current
    LaunchedEffect(cityName, units) {
        viewModel.getWeather(cityName, units)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "",
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->

        when (val state = weatherState) {
            is WeatherUiState.Loading -> {
                LoadingState(paddingValues)
            }

            is WeatherUiState.Success -> {
                WeatherContent(
                    weather = state.data,
                    units = units,
                    paddingValues = paddingValues,
                    onToggleUnits = {
                        units = if (units == "metric") "imperial" else "metric"
                    },
                    onForecastClick = {
                        onForecastClick(
                            DayForecastQuery(
                                cityName,
                                state.data.lat,
                                state.data.lon,
                                units
                            )
                        )
                    }
                )
            }

            is WeatherUiState.Error -> {
                LaunchedEffect(state.message) {
                    Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}