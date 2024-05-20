package com.example.mechtatestassignment.util

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavigation = staticCompositionLocalOf<NavHostController> { error("Not provided") }