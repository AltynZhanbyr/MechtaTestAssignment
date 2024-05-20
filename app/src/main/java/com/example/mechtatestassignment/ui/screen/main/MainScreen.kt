package com.example.mechtatestassignment.ui.screen.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mechtatestassignment.ui.component.SmartphoneItem
import com.example.mechtatestassignment.ui.navigation.Screen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainScreen() = composable(route = Screen.MainScreen.route) {
    MainScreen()
}


@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainViewModel>()
    val state = viewModel.state.collectAsStateWithLifecycle().value

    val context = LocalContext.current

    LaunchedEffect(key1 = state.message) {
        if (state.message.isNotBlank()) {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            viewModel.cleanMessage()
        }
    }

    MainScreen(
        state = state,
        action = { actions ->
            viewModel.fetchActions(actions)
        }
    )
}

@Composable
private fun MainScreen(
    state: MainUiState,
    action: (MainScreenAction) -> Unit
) {

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(state.items.size) { i ->
                    val item = state.items[i]
                    if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                        action(MainScreenAction.LoadNextItems)
                    }
                    SmartphoneItem(
                        item = item,
                        onItemClick = { selectedItem ->
                            action(MainScreenAction.ItemClick(selectedItem))
                        },
                        onFavoriteClick = { selectedItem ->
                            action(MainScreenAction.FavoriteToggle(selectedItem))
                        },
                    )
                }
                item {
                    if (state.isLoading) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}