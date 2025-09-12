package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.ui.screen.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController , startDestination = ROUTES.HOME_SCREEN){
        composable(ROUTES.HOME_SCREEN) { HomeScreen(navController) }
    }
}