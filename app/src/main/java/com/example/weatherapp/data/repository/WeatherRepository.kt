package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.RetrofitInstance

/**
 * 🟢 WeatherRepository
 * Acts as the single source of truth for weather data.
 *
 * This class is responsible for fetching data from the remote API.
 * Later, it could also include caching logic (Room, DataStore)
 * to combine local + remote data in one place.
 */
class WeatherRepository {

    /**
     * Fetches weather forecast for a given location.
     *
     * @param location The location name or coordinates (e.g., "London", "48.8566,2.3522").
     * @return WeatherResponseDto containing location, current weather, and forecast info.
     *
     * NOTE: The API key is currently hardcoded for simplicity.
     * In a production app, consider using a secure storage or BuildConfig field.
     */
    suspend fun getWeatherForecast(location: String) =
        RetrofitInstance.api.getForecast(
            apiKey = "03eb373dc20d47008c1153630230104", // ⚠️ Move to BuildConfig for security
            location = location
        )
}
