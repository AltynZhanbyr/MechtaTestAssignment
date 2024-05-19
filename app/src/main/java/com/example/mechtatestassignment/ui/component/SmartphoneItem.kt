package com.example.mechtatestassignment.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mechtatestassignment.domain.model.Item

@Composable
fun SmartphoneItem(
    item: Item
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color.Gray)
            .padding(16.dp)
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (item.photos.isNotEmpty()) {
            AsyncImage(
                model = item.photos[0],
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 8.dp)
            )
        }

        Text(
            text = "${item.price} тг.",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (item.isFavorite) {
            Text(
                text = "Favorite",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        } else {
            Text(
                text = "Not Favorite",
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}