package com.example.mechtatestassignment.ui.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController

fun NavHostController.navigateToDetails(code: String) {
    navigate(Screen.DetailsScreen.argRoute(code))
}

fun <T> SavedStateHandle?.getOnce(key: String): T? {
    val result = this?.get<T>(key)
    this?.remove<T>(key)
    return result
}