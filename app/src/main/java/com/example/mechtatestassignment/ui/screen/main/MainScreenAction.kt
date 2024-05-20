package com.example.mechtatestassignment.ui.screen.main

import com.example.mechtatestassignment.domain.model.Item

interface MainScreenAction {
    data object LoadNextItems : MainScreenAction
    data class ItemClick(val selectedItem: Item) : MainScreenAction
    data class FavoriteToggle(val selectedItem: Item) : MainScreenAction
}