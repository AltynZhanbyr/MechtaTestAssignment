package com.example.mechtatestassignment.ui.screen.details

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mechtatestassignment.ui.navigation.Screen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.detailsScreen() = composable(route = Screen.DetailsScreen.route) { backStack ->
    val code = backStack.arguments?.getString("code").orEmpty()
    val viewModel = koinViewModel<DetailsViewModel> {
        parametersOf(code)
    }

    DetailsScreen(
        viewModel = viewModel
    )
}

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    LaunchedEffect(key1 = state.message) {
        if (state.message.isNotBlank()) {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            viewModel.cleanMessage()
        }
    }

    Text(text = state.detailsDto?.name ?: "Пусто")
}