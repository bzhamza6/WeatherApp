package com.example.weatherapp.data.model


// 🟢 1. Location
data class LocationDto(
    val name: String,
    val region: String,
    val country: String,
    val localtime: String
)

// 🟢 2. Current Weather
data class CurrentWeatherDto(
    val last_updated_epoch: String,
    val last_updated: String,
    val temp_c: String,
    val feelslike_c: String,
    val humidity: String,
    val wind_kph: String,
    val wind_dir: String,
    val pressure_mb: String,
    val uv: String,
    val condition: ConditionDto
)

// 🟢 3. Condition (مشتركة بين current/day/hour)
data class ConditionDto(
    val text: String,
    val icon: String
)

// 🟢 4. Forecast Response
data class ForecastDto(
    val forecastday: List<ForecastDayDto>
)

data class ForecastDayDto(
    val date: String,
    val day: DayDto,
    val astro: AstroDto,
    val hour: List<HourDto>
)

// 🟢 5. Day Info
data class DayDto(
    val maxtemp_c: String,
    val mintemp_c: String,
    val daily_chance_of_rain: String,
    val condition: ConditionDto
)

// 🟢 6. Astro Info
data class AstroDto(
    val sunrise: String, val sunset: String
)

// 🟢 7. Hour Info
data class HourDto(
    val time: String,
    val temp_c: String,
    val chance_of_rain: String,
    val condition: ConditionDto,
    val humidity: String,
    val cloud: String
)

// 🟢 8. Response النهائي
data class WeatherResponseDto(
    val location: LocationDto,
    val current: CurrentWeatherDto,
    val forecast: ForecastDto
)