package com.mobilebreakero.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.paging.compose.LazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.mobilebreakero.common.domain.model.MovieItem

@Composable
fun MoviesTopImage(
    movies: LazyPagingItems<MovieItem>,
    itemIndex: Int,
) {
    SubcomposeAsyncImage(
        model = "https://image.tmdb.org/t/p/original/" + movies[itemIndex]?.posterUrl,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        loading = {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    color = Color.White, modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                )
            }
        },
        contentScale = ContentScale.FillBounds
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
    )
}