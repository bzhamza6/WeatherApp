package com.example.weatherapp.data.model

/**
 * 🟢 1. Location information
 * Represents the basic location data returned from the API.
 */
data class LocationDto(
    val name: String,       // City name
    val region: String,     // Region or state
    val country: String,    // Country name
    val localtime: String   // Local time at the location
)

/**
 * 🟢 2. Current Weather
 * Holds the real-time weather details for the given location.
 */
data class CurrentWeatherDto(
    val last_updated_epoch: String, // Last update time (epoch format)
    val last_updated: String,       // Last update time (readable format)
    val temp_c: String,             // Current temperature in °C
    val feelslike_c: String,        // Feels-like temperature in °C
    val humidity: String,           // Humidity percentage
    val wind_kph: String,           // Wind speed in kph
    val wind_dir: String,           // Wind direction (N, E, S, W)
    val pressure_mb: String,        // Atmospheric pressure in mb
    val uv: String,                 // UV index
    val condition: ConditionDto     // Weather condition (text + icon)
)

/**
 * 🟢 3. Condition
 * Shared between current weather, daily forecast, and hourly forecast.
 */
data class ConditionDto(
    val text: String,   // Condition description (e.g., "Sunny")
    val icon: String    // Icon URL for the condition
)

/**
 * 🟢 4. Forecast Response
 * Contains the forecast data for multiple days.
 */
data class ForecastDto(
    val forecastday: List<ForecastDayDto> // List of forecast details per day
)

/**
 * Represents a single forecasted day including:
 * - General day summary
 * - Astronomical data
 * - Hourly forecast
 */
data class ForecastDayDto(
    val date: String,              // Date of the forecast (YYYY-MM-DD)
    val day: DayDto,               // Day summary (max/min temp, condition)
    val astro: AstroDto,           // Sunrise/sunset info
    val hour: List<HourDto>        // Hourly forecast data
)

/**
 * 🟢 5. Day Info
 * Stores general info for the whole day.
 */
data class DayDto(
    val maxtemp_c: String,              // Max temperature (°C)
    val mintemp_c: String,              // Min temperature (°C)
    val daily_chance_of_rain: String,   // Chance of rain in percentage
    val condition: ConditionDto         // Day weather condition
)

/**
 * 🟢 6. Astro Info
 * Astronomical data for the given day.
 */
data class AstroDto(
    val sunrise: String,   // Sunrise time
    val sunset: String     // Sunset time
)

/**
 * 🟢 7. Hour Info
 * Represents weather data for a specific hour of the day.
 */
data class HourDto(
    val time: String,              // Hour (YYYY-MM-DD HH:mm)
    val temp_c: String,            // Temperature at this hour (°C)
    val chance_of_rain: String,    // Chance of rain at this hour (%)
    val condition: ConditionDto,   // Weather condition for this hour
    val humidity: String,          // Humidity percentage
    val cloud: String              // Cloud coverage percentage
)

/**
 * 🟢 8. Final Response
 * The root object returned by the API containing:
 * - Location info
 * - Current weather
 * - Forecast data
 */
data class WeatherResponseDto(
    val location: LocationDto,         // Location details
    val current: CurrentWeatherDto,    // Current weather
    val forecast: ForecastDto          // Forecast details
)
