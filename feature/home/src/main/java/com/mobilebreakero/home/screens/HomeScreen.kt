package com.mobilebreakero.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobilebreakero.home.components.CarouselIndicatorWithRectangleShape
import com.mobilebreakero.home.components.GenreList


@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent(){

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Black).verticalScroll(rememberScrollState())
    ) {
        CarouselIndicatorWithRectangleShape()
        Spacer(modifier = Modifier.height(10.dp))
        GenreList()
    }

}