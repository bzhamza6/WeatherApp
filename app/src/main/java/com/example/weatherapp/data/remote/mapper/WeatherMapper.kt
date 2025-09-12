package com.example.weatherapp.data.remote.mapper

import com.example.weatherapp.data.remote.dto.current.CurrentWeatherResponse
import com.example.weatherapp.domain.model.Weather

fun CurrentWeatherResponse.toDomain(): Weather {
    return Weather(
        city = location.name,
        country = location.country,
        temperature = current.temp_c,
        feelsLike = current.feelslike_c,
        humidity = current.humidity,
        condition = current.condition.text,
        iconUrl = "https:${current.condition.icon}"
    )
}