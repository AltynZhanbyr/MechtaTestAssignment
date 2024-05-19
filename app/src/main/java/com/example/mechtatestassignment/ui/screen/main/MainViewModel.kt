package com.example.mechtatestassignment.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getSmartphonesUseCase: GetSmartphonesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun cleanMessage() {
        _state.update { state ->
            state.copy(
                message = ""
            )
        }
    }

    @OptIn(FlowPreview::class)
    private fun fetchData() {
        viewModelScope.launch {
            getSmartphonesUseCase.invoke(1, 30, "smartfony")
                .debounce(300L)
                .onStart {
                    _state.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
                .catch { throwable ->
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            message = throwable.message.orEmpty()
                        )
                    }
                }
                .collect { items ->
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            items = items
                        )
                    }
                }
        }
    }

}