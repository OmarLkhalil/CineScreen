package com.mobilebreakero.home.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.tv.material3.Carousel
import androidx.tv.material3.CarouselDefaults
import androidx.tv.material3.CarouselState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.mobilebreakero.home.viewmodel.MoviesViewModel

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun CarouselIndicatorWithRectangleShape(viewModel: MoviesViewModel = hiltViewModel()) {

    val movies = viewModel.movies.value.movie!!.flow.collectAsLazyPagingItems()

    val carouselState = remember { CarouselState() }

    if (viewModel.movies.value.isLoading) {
        Box(modifier = Modifier.size(50.dp)){
            CircularProgressIndicator()
        }

    } else if (viewModel.movies.value.error.isNotEmpty()) {

        Text("Error: ${viewModel.movies.value.error}")

    } else {

        val count = movies.itemCount

        Carousel(
            itemCount = count,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            carouselState = carouselState,
            carouselIndicator = {
                CarouselDefaults.IndicatorRow(
                    itemCount = 10,
                    activeItemIndex = carouselState.activeItemIndex,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp),
                    indicator = { isActive ->
                        val activeColor = Color.Red
                        val inactiveColor = activeColor.copy(alpha = 0.5f)
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (isActive) activeColor else inactiveColor,
                                    shape = RectangleShape,
                                ),
                        )
                    }
                )
            },
            contentTransformEndToStart =
            fadeIn(tween(1000)).togetherWith(fadeOut(tween(1000))),
            contentTransformStartToEnd =
            fadeIn(tween(1000)).togetherWith(fadeOut(tween(1000)))
        ) { itemIndex ->

            Box(
                modifier = Modifier
                    .border(2.dp, Color.Black.copy(alpha = 0.5f))
                    .fillMaxSize()
            ) {
                MoviesTopImage(movies, itemIndex)

                var isFocused by remember { mutableStateOf(false) }

                Text(
                    text = movies[itemIndex]!!.name!!,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .onFocusChanged { isFocused = it.isFocused }
                        .animateEnterExit(
                            enter = slideInHorizontally(animationSpec = tween(1000)) { it / 2 },
                            exit = slideOutHorizontally(animationSpec = tween(1000))
                        )
                        .border(
                            width = 2.dp,
                            color = if (isFocused) Color.Red else Color.Transparent,
                            shape = RoundedCornerShape(50)
                        )
                        .padding(vertical = 2.dp, horizontal = 5.dp)
                        .align(Alignment.BottomStart)
                )
            }
        }
    }
}