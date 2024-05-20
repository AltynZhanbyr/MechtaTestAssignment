package com.example.mechtatestassignment.ui.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateToDetails(code: String) {
    navigate(Screen.DetailsScreen.argRoute(code))
}