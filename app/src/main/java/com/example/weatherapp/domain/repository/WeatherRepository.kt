package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(city: String): Flow<Resource<Weather>>
}