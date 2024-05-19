package com.example.mechtatestassignment.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mechtatestassignment.ui.component.SmartphoneItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainViewModel>()

    val state = viewModel.state.collectAsStateWithLifecycle().value
    MainScreen(state = state)
}

@Composable
private fun MainScreen(
    state: MainUiState
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if (state.isLoading)
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            else {
                LazyColumn {
                    items(state.items) { item ->
                        SmartphoneItem(item = item)
                    }
                }
            }
        }
    }
}