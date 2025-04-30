package com.muhammad.cityinput.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CityInputScreen(
    onCitySelected: (String) -> Unit
) {
    val viewModel: CityInputViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search for a city",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(
                    Alignment.CenterHorizontally
                )
        )

        OutlinedTextField(
            value = state.cityName,
            onValueChange = viewModel::onCityNameChanged,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("City name") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = {
                    viewModel.saveCity()
                    onCitySelected(state.cityName)
                    viewModel.onCityNameChanged("")
                }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            }
        )

        if (state.recentCities.isNotEmpty()) {
            Text(
                text = "Recent searches",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(top = 8.dp)
            ) {
                items(items = state.recentCities, key = { it }) { city ->
                    Text(
                        text = city,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.onCityNameChanged(city)
                                onCitySelected(city)
                            }
                            .padding(vertical = 12.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}