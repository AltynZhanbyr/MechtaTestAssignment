package com.example.mechtatestassignment.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import com.example.mechtatestassignment.util.AppPreferences
import com.example.mechtatestassignment.util.consts.PAGING_PAGE_SIZE
import com.example.mechtatestassignment.util.paging.PagingImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val appPreferences: AppPreferences,
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
                var newItems = state.items + items
                newItems = newItems.map { item ->
                    item.copy(
                        isFavorite = appPreferences.getBoolean(item.code)
                    )
                }

                state.copy(
                    items = newItems,
                    pageInitial = newKey,
                    endReached = items.isEmpty(),
                )
            }
        }
    )

    init {
        loadNextItems()
    }

    fun cleanMessage() {
        _state.update { state ->
            state.copy(
                message = ""
            )
        }
    }

    fun fetchActions(action: MainScreenAction) {
        when (action) {
            is MainScreenAction.LoadNextItems -> loadNextItems()
            is MainScreenAction.ItemClick -> {}
            is MainScreenAction.FavoriteToggle -> action.favoriteToggle()
        }
    }

    fun replaceItemFavorite(
        isFavorite: Boolean?,
        code: String?
    ) {
        if (isFavorite == null && code == null) return

        _state.update { currentState ->
            val updatedItems = currentState.items.map { item ->
                if (item.code == code) {
                    item.copy(isFavorite = isFavorite!!)
                } else {
                    item
                }
            }

            currentState.copy(items = updatedItems)
        }
    }

    private fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    private fun MainScreenAction.FavoriteToggle.favoriteToggle() {
        _state.update { state ->
            val list = state.items.toMutableList()
            val idx = list.indexOf(selectedItem)

            list.removeAt(idx)

            val isFavorite = !selectedItem.isFavorite
            appPreferences.setBoolean(selectedItem.code, isFavorite)

            val newItem = selectedItem.copy(isFavorite = isFavorite)
            list.add(idx, newItem)

            state.copy(
                items = list
            )
        }
    }
}