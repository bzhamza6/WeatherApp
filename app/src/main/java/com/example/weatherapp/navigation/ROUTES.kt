package com.example.weatherapp.navigation

// 🟢 ROUTES: Object that holds the navigation routes used in the app.
// ➤ Purpose: Avoid using hardcoded strings when navigating between screens.
// ➤ Makes it easier to update route names in one place.

object ROUTES {

    // 🏠 Route name for the Home screen.
    val HOME_SCREEN = "Home"

    // 🔍 Route name for the Search screen.
    val SEARCH_SCREEN = "Search"

    // 📍 Route name for the Location List screen (saved locations).
    val LOCATION_LIST_SCREEN = "LocationList"
}
