package com.example.weatherapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.ui.components.CurrentWeatherCard
import com.example.weatherapp.ui.components.HourlyForecastCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController) {
    // Scaffold: Provides the basic structure of the screen (TopBar + Content)
    Scaffold(
        topBar = {
            // TopAppBar: The top bar of the screen
            TopAppBar(
                title = {
                    // Row: Arranges the elements horizontally with space between them
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Button: Add a new location
                        IconButton(onClick = { /* TODO: Navigate to Add/Search Location Screen */ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Location"
                            )
                        }

                        // Screen title in the center
                        Text(text = "Today", color = Color.Black)

                        // Button: Show saved locations menu
                        IconButton(onClick = { /* TODO: Open Saved Locations Screen */ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                })
        }
    ) { paddingValues ->
        // Box: Container to display the main screen content
        Box(
            modifier = Modifier.padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            // LazyColumn: Scrollable vertical list
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) // Space between list items
            ) {
                // Item 1: Current Weather Card
                item {
                    CurrentWeatherCard(
                        locationName = "London",
                        temp_c = "34.5",
                        conditionwth = "Sunny",
                        iconWth = "lINK Icon here" // TODO: Provide the correct weather icon link
                    )
                }

                // Item 2: Hourly Weather Forecast
                item {
                    Text(text = "Hourly Forecast")
                    Spacer(modifier = Modifier.height(8.dp))

                    // LazyRow: Scrollable horizontal list for hourly forecast
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // TODO: Pass the actual HourlyForecast list
                        // Example:
                        // items(HourlyForecastList) { forecast ->
                        //     HourlyForecastCard(forecast)
                        // }
                    }
                }

                // Item 3: Additional weather states or statistics
                item {
                    // TODO: WeatherStateGrid() → Display extra weather info like humidity, wind, etc.
                }

                // Item 4: Multi-day weather forecast
                /*
                items(ForecastDayList) { forecastDay ->
                    ForecastDayCard(forecastDay)
                }
                */
            }
        }
    }
}
