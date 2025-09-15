package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 🟢 WeatherApiService
 * Retrofit interface that defines the API endpoints for the weather app.
 *
 * Each function here corresponds to a network request.
 * Retrofit will automatically generate the implementation at runtime.
 */
interface WeatherApiService {

    /**
     * Fetches the weather forecast data from the API.
     *
     * @param apiKey Your WeatherAPI key (required).
     * @param location The location for which to fetch weather data (city name, lat/long, etc.).
     * @param days Number of days for forecast (default: 7 days).
     * @param aqi Whether to include air quality data ("yes" or "no", default: "no").
     * @param alerts Whether to include weather alerts ("yes" or "no", default: "no").
     *
     * @return WeatherResponseDto - a parsed data object containing location, current weather, and forecast info.
     */
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 7,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherResponseDto
}
