package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 🟢 WeatherStateGrid Composable
// ➤ Purpose: Displays a 2x2 grid of weather information (Humidity, Wind, Rain Chance, Feels Like).
// ➤ Each item is represented by a WeatherCard with an icon, title, and value.
// ➤ Designed to give the user a quick overview of key weather metrics.

@Composable
fun WeatherStateGrid(
    humedity: String, // 💧 Humidity percentage
    wind: String,     // 🌬️ Wind speed in km/h
    rain: String,     // 🌧️ Chance of rain in %
    feelsL: String,   // 🌡️ "Feels Like" temperature
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp) // 📏 Space between rows
    ) {
        // 🔸 First row: Humidity + Wind
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // 📏 Space between cards
        ) {
            WeatherCard(
                title = "HUMIDITY",
                value = "$humedity%",
                icon = {
                    Icon(
                        Icons.Default.WaterDrop,
                        contentDescription = "Humidity",
                        tint = MaterialTheme.colorScheme.primary // 🎨 Blue-ish for water
                    )
                },
                modifier = Modifier.weight(1f) // ⚖️ Equal width for both cards
            )
            WeatherCard(
                title = "WIND",
                value = "$wind km/h",
                icon = {
                    Icon(
                        Icons.Default.Air,
                        contentDescription = "Wind",
                        tint = MaterialTheme.colorScheme.secondary // 🎨 Different accent color
                    )
                },
                modifier = Modifier.weight(1f)
            )
        }

        // 🔸 Second row: Chance of Rain + Feels Like
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WeatherCard(
                title = "CHANCE OF RAIN",
                value = "$rain%",
                icon = {
                    Icon(
                        Icons.Default.Cloud,
                        contentDescription = "Rain",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.weight(1f)
            )
            WeatherCard(
                title = "FEELS LIKE",
                value = "$feelsL°",
                icon = {
                    Icon(
                        Icons.Default.Thermostat,
                        contentDescription = "Feels Like",
                        tint = MaterialTheme.colorScheme.error // 🔴 Uses error color for temperature
                    )
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// 🟢 WeatherCard Composable
// ➤ Purpose: Small reusable card showing a weather metric with icon + title + value.
// ➤ Used inside WeatherStateGrid for each weather parameter.

@Composable
fun WeatherCard(
    title: String,              // 🏷️ Title of the metric (e.g., "HUMIDITY")
    value: String,              // 📊 Metric value (e.g., "72%")
    icon: @Composable () -> Unit, // 🎨 Icon representing the metric
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .height(120.dp), // 📏 Fixed card height for consistent UI
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // 🎨 Background color
        ),
        elevation = CardDefaults.cardElevation(4.dp) // 🖼️ Slight shadow for depth
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween // 🏗️ Distribute icon/title + value vertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                icon() // 🎨 Displays the weather metric icon
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 📊 Main value (e.g., 23°, 70%, 15km/h)
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}
