package com.example.weatherapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String? = null
)

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state


    fun loadWeather(city: String) {
        viewModelScope.launch {
            repository.getWeather(city).collect { resource ->
                _state.value = when (resource) {
                    is Resource.Loading -> WeatherState(isLoading = true)
                    is Resource.Success -> WeatherState(weather = resource.data)
                    is Resource.Error -> WeatherState(error = resource.errorMessage)
                }
            }
        }
    }
}