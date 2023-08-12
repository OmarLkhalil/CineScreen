package com.mobilebreakero.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.mobilebreakero.components.TrailsVideos

@Composable
fun DetailsScreen(
    navController: NavController,
    lifecycle: LifecycleOwner,
    movieId: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )
    {
        TrailsVideos(
            navController = navController,
            lifecycle = lifecycle,
            movieId = movieId,
        )
    }
}