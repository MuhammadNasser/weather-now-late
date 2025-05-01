package com.muhammad.dayforecast.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.muhammad.core.model.local.DailyForecast
import androidx.compose.foundation.layout.size

@Composable
fun ForecastItem(forecast: DailyForecast) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = forecast.date, style = MaterialTheme.typography.headlineMedium)
            Text(text = forecast.description)
            Text(text = forecast.summary)
            Text(text = forecast.temp)
        }
        Image(
            painter = rememberAsyncImagePainter(forecast.icon),
            contentDescription = forecast.description,
            modifier = Modifier.size(64.dp)
        )
    }
}