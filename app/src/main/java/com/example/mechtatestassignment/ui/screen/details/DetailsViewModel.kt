package com.example.mechtatestassignment.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtatestassignment.domain.useCase.GetSmartphoneDetailsUseCase
import com.example.mechtatestassignment.util.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val appPreferences: AppPreferences,
    private val getSmartphoneDetailsUseCase: GetSmartphoneDetailsUseCase,
    private val code: String
) : ViewModel() {
    private val _state = MutableStateFlow(DetailsState())
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

    fun toggleFavorite() {
        _state.update { state ->
            val isFavoriteToggled = !(state.details?.isFavorite ?: false)
            appPreferences.setBoolean(code, isFavoriteToggled)

            state.copy(
                details = state.details?.copy(
                    isFavorite = isFavoriteToggled
                )
            )
        }
    }

    @OptIn(FlowPreview::class)
    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            getSmartphoneDetailsUseCase(code)
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
                            message = throwable.message ?: "Unexpected error"
                        )
                    }
                }
                .collect { details ->
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            details = details.copy(
                                isFavorite = appPreferences.getBoolean(code)
                            ),
                        )
                    }
                }
        }
    }
}