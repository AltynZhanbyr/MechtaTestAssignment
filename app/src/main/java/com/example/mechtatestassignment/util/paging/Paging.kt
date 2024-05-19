package com.example.mechtatestassignment.util.paging

interface Paging<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}