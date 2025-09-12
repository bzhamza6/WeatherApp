package com.example.weatherapp.domain.model

data class Weather(
    val city: String,
    val country: String,
    val temperature: Double,
    val feelsLike: Double,
    val humidity: Int,
    val condition: String,
    val iconUrl: String
)