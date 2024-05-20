package com.example.mechtatestassignment.ui.component

import androidx.compose.animation.Animatable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mechtatestassignment.domain.model.Item

@Composable
fun SmartphoneItem(
    item: Item,
    modifier: Modifier = Modifier,
    onItemClick: (Item) -> Unit,
    onFavoriteClick: (Item) -> Unit
) {
    val color = remember { Animatable(Color.Gray) }
    LaunchedEffect(item.isFavorite) {
        color.animateTo(if (item.isFavorite) Color.Red else Color.Gray)
    }

    Card(
        modifier = modifier
            .padding(10.dp)
            .clickable {
                onItemClick(item)
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Text(
                text = item.name,
                modifier = Modifier
            )

            if (item.photos.isNotEmpty()) {
                AsyncImage(
                    model = item.photos[0],
                    contentDescription = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Text(
                text = "${item.price} тг.",
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "В избранное",
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    onFavoriteClick(item)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = color.value
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SmartphoneItemPrev() {
    MaterialTheme {
        val item = Item(
            id = 1522,
            name = "Samsung",
            photos = listOf("https://www.mechta.kz/export/1cbitrix/import_files/01/010cd404-b5ad-11ee-a264-005056b6dbd7.png"),
            price = 70000
        )
        SmartphoneItem(
            item = item,
            onFavoriteClick = {},
            onItemClick = {}
        )
    }
}