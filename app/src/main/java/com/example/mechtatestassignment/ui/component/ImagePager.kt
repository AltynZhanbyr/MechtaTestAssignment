package com.example.mechtatestassignment.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageSlider(
    photos: List<String>,
    contentDescription: String?,
) {
    val state = rememberPagerState {
        photos.size
    }
    Column {
        HorizontalPager(state = state) { idx ->
            AsyncImage(
                model = photos[idx],
                contentDescription = contentDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        PagerIndicator(state)
    }
}