package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.navigation.NavigationGraph
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherForecastViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔳 Enables edge-to-edge layout (status & navigation bar handling)
        enableEdgeToEdge()

        // 🎨 Set the content of the activity using Jetpack Compose
        setContent {
            // Apply the custom Material3 theme for the app
            WeatherAppTheme {

                // 🔗 Create a NavController to handle navigation between screens
                val navController = rememberNavController()

                // 🧠 Get an instance of the ViewModel (scoped to this Activity)
                val viewModelForecastWeather: WeatherForecastViewModel = viewModel()

                // 🗺️ Call the NavigationGraph composable to set up navigation routes
                NavigationGraph(
                    navController,
                    viewModelForecastWeather
                )
            }
        }
    }
}
