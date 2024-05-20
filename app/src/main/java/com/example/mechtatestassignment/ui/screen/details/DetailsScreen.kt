package com.example.mechtatestassignment.ui.screen.details

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mechtatestassignment.ui.component.ImageSlider
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

    DetailsScreen(state = state)
}

@Composable
private fun DetailsScreen(
    state: DetailsState
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if (state.isLoading)
                Box(modifier = Modifier.align(Alignment.Center)) {
                    CircularProgressIndicator()
                }
            else LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                item {
                    ImageSlider(
                        photos = state.details?.photos ?: emptyList(),
                        contentDescription = state.details?.name
                    )
                }

                item {
                    Text(
                        text = state.details?.name.orEmpty(),
                        style = TextStyle(
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                item {
                    ProductRow(title = "Цена", value = "${state.details?.price ?: 0} тг.")
                }

                val properties = state.details?.properties

                properties?.let {
                    items(it) { property ->
                        ProductRow(
                            title = property.propName,
                            value = property.propValue
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductRow(
    title: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}