package com.muhammad.currentweather.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.muhammad.core.model.local.CurrentWeather
import com.muhammad.currentweather.R
import com.muhammad.weatherkit.formatTemperature
import com.muhammad.weatherkit.weatherConditionIcon

@Composable
fun WeatherContent(
    weather: CurrentWeather,
    units: String,
    paddingValues: PaddingValues,
    onToggleUnits: () -> Unit,
    onForecastClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.current_weather_in, weather.cityName),
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.headlineMedium
        )


        Text(
            text = weather.temp.formatTemperature(units),
            fontSize = 48.sp
        )

        Text(
            text = weather.description,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = rememberAsyncImagePainter(weather.condition.weatherConditionIcon()),
            contentDescription = weather.description,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onToggleUnits) {
            Text(text = stringResource(R.string.change_unit))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onForecastClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(text = stringResource(R.string._7_day_forecast))
        }
    }
}