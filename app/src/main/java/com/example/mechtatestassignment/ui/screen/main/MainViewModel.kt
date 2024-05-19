package com.example.mechtatestassignment.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import com.example.mechtatestassignment.util.consts.PAGING_PAGE_SIZE
import com.example.mechtatestassignment.util.paging.PagingImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getSmartphonesUseCase: GetSmartphonesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    private val paginator = PagingImpl(
        initialKey = state.value.pageInitial,
        onLoadUpdated = { loaded ->
            _state.update { state ->
                state.copy(
                    isLoading = loaded
                )
            }
        },
        onRequest = { nextPage ->
            getSmartphonesUseCase(nextPage, PAGING_PAGE_SIZE)
        },
        getNextKey = {
            state.value.pageInitial + 1
        },
        onError = { throwable ->
            _state.update { state ->
                state.copy(
                    message = throwable?.message ?: "UnexpectedError"
                )
            }
        },
        onSuccess = { items, newKey ->
            _state.update { state ->
                state.copy(
                    items = state.items + items,
                    pageInitial = newKey,
                    endReached = items.isEmpty()
                )
            }
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    fun cleanMessage() {
        _state.update { state ->
            state.copy(
                message = ""
            )
        }
    }


}