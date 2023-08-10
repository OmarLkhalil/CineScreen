package com.mobilebreakero.search

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
import androidx.navigation.NavController


@Composable
fun SearchScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Black).verticalScroll(rememberScrollState())
    ) {
    }

}
