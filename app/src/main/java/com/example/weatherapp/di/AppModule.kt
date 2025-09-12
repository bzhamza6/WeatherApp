package com.example.weatherapp.di

import com.example.weatherapp.data.remote.api.WeatherServiceApi
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.screens.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherServiceApi::class.java)
    }

    // Repository
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    // ViewModel
    viewModel { WeatherViewModel(get()) }
}