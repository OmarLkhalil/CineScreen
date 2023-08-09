package com.mobilebreakero.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.mobilebreakero.common.domain.model.MovieItem
import com.mobilebreakero.home.Constants

@Composable
fun MoviesItem(movie: MovieItem) {

    Box(
        modifier = Modifier
            .size(120.dp, 120.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        SubcomposeAsyncImage(
            model = Constants.BASE_URL + movie.posterUrl,
            contentDescription = movie.name,
            modifier = Modifier,
            contentScale = ContentScale.FillBounds,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.7f))
                .height(35.dp)
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        Text(
            text = movie.name!!,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        }
    }
}