package com.example.mechtatestassignment.ui.screen.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        viewModel
    )
}

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Text(text = state.detailsDto?.name ?: "Пусто")
}