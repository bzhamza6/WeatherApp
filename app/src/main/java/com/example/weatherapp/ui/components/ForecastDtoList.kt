package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.data.model.ForecastDayDto
import com.example.weatherapp.halperFun.FormatHourAndDate

// 🟢 ForecastDtoList Composable
// ➤ Purpose: Displays a single day's weather forecast inside a card.
// ➤ Shows: Weather icon, day name, weather condition text, and max temperature.
// ➤ Used in a LazyColumn or list to display multiple days of forecasts.

@Composable
fun ForecastDtoList(forecastDaily: ForecastDayDto) {

    val dateFormatter = FormatHourAndDate() // 🗓️ Helper class to format date into day name

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // 🎨 Card background color
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 🖼️ Weather Icon (Loaded from API using Coil)
            AsyncImage(
                model = "https:${forecastDaily.day.condition.icon}", // Full image URL
                contentDescription = "Weather Icon",
                modifier = Modifier.size(42.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // 📄 Column showing day name & weather description
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                // 🗓️ Day Name (e.g., Monday, Tuesday)
                Text(
                    text = dateFormatter.getDayName(forecastDaily.date.toString()),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                // ☁️ Weather Condition Text
                Text(
                    text = forecastDaily.day.condition.text,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            // 🌡️ Max Temperature (Right-aligned)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = "${forecastDaily.day.maxtemp_c}°",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}
