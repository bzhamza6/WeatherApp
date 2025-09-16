package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherResponseDto
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherForecastViewModel(
    private val repository: WeatherRepository = WeatherRepository()
) : ViewModel() {

    // 🔄 Loading state: used to show/hide progress indicators in the UI
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // 🌤️ Holds the weather data fetched from the API
    private val _weatherdata = MutableStateFlow<WeatherResponseDto?>(null)
    val weatherdata: StateFlow<WeatherResponseDto?> = _weatherdata

    // ❌ Holds any error message if the API request fails
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    /**
     * Fetches weather data for a specific location.
     * Uses viewModelScope + Dispatchers.IO to run network request on a background thread.
     */
    fun getWeatherData(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true // Start loading state
            _error.value = null // Clear previous error (if any)

            try {
                // ✅ Call repository to fetch data from API
                _weatherdata.value = repository.getWeatherForecast(location)
            } catch (e: Exception) {
                // ❌ If there is an exception, store the error message
                _error.value = e.message
            } finally {
                // ⏹ Stop loading state whether success or failure
                _isLoading.value = false
            }
        }
    }
}
