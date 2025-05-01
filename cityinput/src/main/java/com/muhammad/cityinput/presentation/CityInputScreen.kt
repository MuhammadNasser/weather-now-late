package com.muhammad.cityinput.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityInputScreen(
    onCitySelected: (String) -> Unit
) {
    val viewModel: CityInputViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Search City") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = state.cityName,
                onValueChange = viewModel::onCityNameChanged,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("City name") },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {
                        if (state.cityName.isNotEmpty()) {
                            viewModel.saveCity()
                            onCitySelected(state.cityName)
                            viewModel.onCityNameChanged("")
                        }
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )

            if (state.recentCities.isNotEmpty()) {
                Text(
                    text = "Recent searches",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
                )

                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(state.recentCities, key = { it }) { city ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onCitySelected(city) }
                                .padding(vertical = 12.dp)
                        ) {
                            Text(
                                text = city,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            HorizontalDivider(
                                thickness = 0.5.dp,
                                color = Color.LightGray,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}