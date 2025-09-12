@file:Suppress("PreviewPickerAnnotation")

package com.example.weatherapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HourlyForecastCard() {
    Card(modifier = Modifier
        .clickable { }
        .padding(4.dp),
        colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) // 🟢 خلفية فاتحة باللون الأساسي

    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp
    )) {
        Column(
            modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🕒 الوقت
            Text(
                text = ("10 AM"), style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ☁️ الأيقونة
            AsyncImage(
                model = "https:",
                contentDescription = "IconStateWeather",
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🌡️ درجة الحرارة
            Text(
                text = "32°",
                style = MaterialTheme.typography.titleLarge.copy(
                    MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
