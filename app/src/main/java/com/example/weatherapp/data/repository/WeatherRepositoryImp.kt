package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.api.WeatherServiceApi
import com.example.weatherapp.data.remote.mapper.toDomain
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.utils.Constants
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val api: WeatherServiceApi
) : WeatherRepository {


    override suspend fun getWeather(city: String): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading())

        try {
            val response = api.getCurrentWeather(Constants.API_KEY, city)
            emit(Resource.Success(response.toDomain()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }
}