@file:Suppress("PreviewPickerAnnotation")

package com.example.weatherapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.data.model.HourDto
import com.example.weatherapp.halperFun.FormatHourAndDate

// 🟢 HourlyForecastCard Composable
// ➤ Purpose: Displays a single hour's weather forecast inside a card.
// ➤ Shows: Hour, weather icon, temperature.
// ➤ Highlights card when selected (e.g., to show active hour).
// ➤ Accepts click callback to handle user interaction.

@Composable
fun HourlyForecastCard(
    hoursdto: HourDto, // 🕒 Data for the specific hour
    onClickedItem: (HourDto) -> Unit, // 🖱️ Callback when user taps the card
    isSelected: Boolean // ✅ If true, card is highlighted (selected state)
) {

    val forma = FormatHourAndDate() // 🗓️ Used to format the time string

    Card(
        modifier = Modifier
            .clickable { onClickedItem(hoursdto) } // 🔗 Triggers callback on tap
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) // 🎨 Highlighted background if selected
            else
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 6.dp else 2.dp // 📌 Higher elevation when selected
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🕒 Hour text (formatted from "yyyy-MM-dd HH:mm" to "h a")
            Text(
                text = forma.formatHour(hoursdto.time.toString()),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (isSelected)
                        MaterialTheme.colorScheme.onPrimary // 🔵 Different text color when selected
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ☁️ Weather icon for this hour
            AsyncImage(
                model = "https:${hoursdto.condition.icon}",
                contentDescription = "IconStateWeather",
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🌡️ Temperature for this hour
            Text(
                text = "${hoursdto.temp_c}°",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = if (isSelected)
                        MaterialTheme.colorScheme.primary // 🔵 Temperature highlighted when selected
                    else
                        MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}
