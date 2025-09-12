package com.example.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    viewModel: WeatherViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    var city by remember { mutableStateOf("") }
    var responseText by remember { mutableStateOf("") }
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter city") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.loadWeather(city) }, modifier = Modifier.fillMaxWidth()) {
            Text("Get Weather")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when {
            state.isLoading -> Text("Loading...")

            state.weather != null -> {
                val weather = state.weather
                responseText = """
                    City: ${weather?.city}
                    Country: ${weather?.country}
                    Temp: ${weather?.temperature}°C
                    Feels Like: ${weather?.feelsLike}°C
                    Condition: ${weather?.condition}
                    Humidity: ${weather?.humidity}%
                """.trimIndent()
                Log.d("WeatherResponse", responseText)

                Text(text = responseText)
            }

            state.error != null -> {
                responseText = "Error: ${state.error}"
                Log.d("WeatherResponse", responseText)
                Text(text = responseText)
            }
        }
    }
}
