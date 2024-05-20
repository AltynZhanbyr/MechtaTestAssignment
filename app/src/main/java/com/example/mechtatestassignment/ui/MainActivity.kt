package com.example.mechtatestassignment.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mechtatestassignment.ui.navigation.Screen
import com.example.mechtatestassignment.ui.screen.details.detailsScreen
import com.example.mechtatestassignment.ui.screen.main.mainScreen
import com.example.mechtatestassignment.ui.theme.MechtaTestAssignmentTheme
import com.example.mechtatestassignment.util.LocalNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navHostController = rememberNavController()
    CompositionLocalProvider(
        LocalNavigation provides navHostController
    ) {
        MechtaTestAssignmentTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavHost(
                    navController = navHostController,
                    startDestination = Screen.MainScreen.route
                ) {
                    mainScreen()
                    detailsScreen()
                }
            }
        }
    }
}
