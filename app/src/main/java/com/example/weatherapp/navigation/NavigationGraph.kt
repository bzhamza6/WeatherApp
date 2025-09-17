package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.ui.screen.HomeScreen
import com.example.weatherapp.viewmodel.WeatherForecastViewModel
import com.example.weatherapp.ui.screen.SearchScreen

/**
 * 🟢 NavigationGraph
 * Defines the navigation graph for the app using Jetpack Compose Navigation.
 *
 * @param navController Used to control navigation between screens.
 * @param viewModelForecast Shared ViewModel that provides weather data to the screens.
 */
@Composable
fun NavigationGraph(
    navController: NavHostController,
    viewModelForecast: WeatherForecastViewModel
) {

    /**
     * LaunchedEffect runs once when this Composable is first composed.
     * Here we trigger the first API call to get weather data for "London".
     *
     * Later, you can replace "London" with a dynamic value (e.g., from user input).
     */
    LaunchedEffect(Unit) {
        viewModelForecast.getWeatherData("London")
    }

    /**
     * NavHost defines the navigation routes in the app.
     * startDestination specifies which screen is shown first.
     */
    NavHost(
        navController = navController,
        startDestination = ROUTES.HOME_SCREEN
    ) {
        // Composable destination for Home Screen
        composable(ROUTES.HOME_SCREEN) {
            HomeScreen(
                navController = navController,
                viewModelfc = viewModelForecast
            )
        }
        composable(ROUTES.SEARCH_SCREEN) { SearchScreen() }
    }

}
