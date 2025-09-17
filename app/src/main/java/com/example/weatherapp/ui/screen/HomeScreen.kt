package com.example.weatherapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.data.model.HourDto
import com.example.weatherapp.ui.components.*
import com.example.weatherapp.viewmodel.WeatherForecastViewModel
import com.example.weatherapp.navigation.ROUTES
import com.example.weatherapp.ui.components.CurrentWeatherCard
import com.example.weatherapp.ui.components.HourlyForecastCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModelfc: WeatherForecastViewModel
) {
    // 🔄 Collect UI state from ViewModel
    val weatherResponse = viewModelfc.weatherdata.collectAsState().value
    val isLoading = viewModelfc.isLoading.collectAsState().value
    val error = viewModelfc.error.collectAsState().value

    // 🌤️ Extract parts of the weather response for easier usage
    val carruntWeatherDay = weatherResponse?.current
    val ForecastWeather = weatherResponse?.forecast
    val LocationWeather = weatherResponse?.location

    // 🕒 Prepare lists for hourly and daily forecast
    val forecastHourlyList = ForecastWeather?.forecastday?.firstOrNull()?.hour ?: emptyList()
    val forecastDailyList = ForecastWeather?.forecastday ?: emptyList()

    // 🏗️ Scaffold provides layout structure with TopBar + Content
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // 🔝 Top row containing "Add", "Title", "Menu"
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // ➕ Button: Add a new location
                        IconButton(onClick = { /* TODO: Navigate to Add/Search Location Screen */ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Location"
                            )
                        }

                        // 🏷️ Center title
                        Text(text = "Today", color = Color.Black)

                        // Button: Show saved locations menu
                        IconButton(onClick = { navController.navigate(ROUTES.SEARCH_SCREEN) }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                })
        }
    ) { paddingValues ->
        // Main container of the screen
        Box(
            modifier = Modifier.padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            when {
                // ⏳ Loading state
                isLoading == true -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Loading...", fontSize = 32.sp)
                    }
                }

                // ✅ Weather data is available
                weatherResponse != null -> {
                    // Keep track of selected hour for "Hourly Forecast"
                    var carrentHourDtoWeather by remember {
                        mutableStateOf<HourDto?>(forecastHourlyList.first())
                    }

                    // 📜 Scrollable vertical list
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // 🔹 1) Current Weather Card
                        item {
                            CurrentWeatherCard(
                                locationName = LocationWeather?.name.toString(),
                                temp_c = carruntWeatherDay?.temp_c.toString(),
                                conditionwth = carruntWeatherDay?.condition?.text.toString(),
                                iconWth = carruntWeatherDay?.condition?.icon.toString()
                            )
                        }

                        // 🔹 2) Hourly Weather Forecast (Scrollable Row)
                        item {
                            Text(text = "Hourly Forecast")
                            Spacer(modifier = Modifier.height(8.dp))

                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(forecastHourlyList) { hourdto ->
                                    HourlyForecastCard(
                                        hoursdto = hourdto,
                                        onClickedItem = { carrentHourDtoWeather = it },
                                        isSelected = carrentHourDtoWeather == hourdto
                                    )
                                }
                            }
                        }

                        // 🔹 3) Weather Stats Grid (Humidity, Wind, Rain, Feels Like)
                        item {
                            Text(text = "Daily Forecast")
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        item {
                            WeatherStateGrid(
                                humedity = carrentHourDtoWeather?.humidity.toString(),
                                wind = carruntWeatherDay?.wind_kph.toString(),
                                rain = carrentHourDtoWeather?.chance_of_rain.toString(),
                                feelsL = carrentHourDtoWeather?.temp_c.toString()
                            )
                        }

                        // 🔹 4) Multi-day forecast list
                        items(forecastDailyList) { forecastDay ->
                            ForecastDtoList(forecastDay)
                        }
                    }
                }

                // ❌ Error state
                error != null -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "ERROR MESSAGE : $error", fontSize = 32.sp)
                    }
                }
            }
        }
    }
}
