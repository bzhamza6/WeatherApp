package com.example.weatherapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 🟢 RetrofitInstance
 * This object is responsible for creating and providing
 * a single instance of Retrofit throughout the app.
 *
 * It ensures that the network client (Retrofit) is initialized
 * only once (Singleton pattern).
 */
object RetrofitInstance {

    // 🌍 Base URL of the weather API
    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    /**
     * Lazily initialized Retrofit API service.
     *
     * - Uses GsonConverterFactory to convert JSON responses into Kotlin objects.
     * - Builds Retrofit with the base URL.
     * - Creates an implementation of the WeatherApiService interface.
     */
    val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Set the base URL for all requests
            .addConverterFactory(GsonConverterFactory.create()) // JSON -> Kotlin objects
            .build()
            .create(WeatherApiService::class.java) // Create API implementation
    }
}
