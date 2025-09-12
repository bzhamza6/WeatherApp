package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.dto.current.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") key: String,
        @Query("q") city: String
    ): CurrentWeatherResponse
}