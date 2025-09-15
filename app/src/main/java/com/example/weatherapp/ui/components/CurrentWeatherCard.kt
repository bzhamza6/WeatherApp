package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

// 🟢 CurrentWeatherCard Composable
// ➤ Purpose: Displays the current weather information (Location, Temperature, Condition, Icon)
// ➤ Used inside HomeScreen to show the main weather card at the top.

@Composable
fun CurrentWeatherCard(
    locationName: String, // 🏙️ City or location name
    temp_c: String,       // 🌡️ Temperature in Celsius
    conditionwth: String, // ☁️ Weather condition text (e.g., "Sunny", "Cloudy")
    iconWth: String       // 🖼️ Icon URL from API
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // 🎨 Card background color
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                // 📍 Location Row (Icon + City Name)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Location",
                        tint = MaterialTheme.colorScheme.primary // 🎨 Icon color
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = locationName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }

                Spacer(Modifier.height(16.dp))

                // 🌡️ Temperature Text
                Text(
                    text = "$temp_c°",
                    style = MaterialTheme.typography.displayLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )

                Spacer(Modifier.height(12.dp))

                // ☁️ Weather Condition Text
                Text(
                    text = conditionwth,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            // 🖼️ Weather Icon (Loaded from API using Coil)
            AsyncImage(
                modifier = Modifier.size(100.dp),
                model = "https:$iconWth", // 🔗 Full URL for the icon
                contentDescription = "Weather Icon",
                alignment = Alignment.Center
            )
        }
    }
}
