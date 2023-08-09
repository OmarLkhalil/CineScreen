package com.mobilebreakero.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobilebreakero.common.domain.model.GenreItemModel


@Composable
fun Chip(
    genre: GenreItemModel,
    selected: Boolean = false,
    onSelected: ((movie: GenreItemModel) -> Unit),
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
) {
    Surface(
        modifier = modifier.clickable {
            onSelected(genre)
        }.padding(contentPadding),
        shape = RoundedCornerShape(10.dp),
        color = if (selected) Color.Red else Color.White,
    ) {
        Text(
            modifier = modifier.padding(contentPadding),
            text = genre.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
        Divider()
    }
}