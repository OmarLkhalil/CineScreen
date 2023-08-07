package com.mobilebreakero.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Carousel
import androidx.tv.material3.ExperimentalTvMaterial3Api


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){}

    Carousel(
        modifier = Modifier.fillMaxSize(),
        itemCount = 2
    ) { item ->
        Box(modifier = Modifier.size(60.dp).background(Color.Red))
    }

}