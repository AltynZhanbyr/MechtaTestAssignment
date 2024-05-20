package com.example.mechtatestassignment.ui.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("mainScreen")
    data object DetailsScreen : Screen("mainScreen/details/{code}") {
        fun argRoute(code: String) = route.replace("{code}", code)
    }
}