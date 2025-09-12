package com.example.weatherapp.data.remote.dto.current

data class CurrentWeatherResponse(
    val current: Current,
    val location: Location
)