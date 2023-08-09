package com.mobilebreakero.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.tv.foundation.lazy.list.TvLazyRow
import com.mobilebreakero.common.domain.model.MovieItem
import com.mobilebreakero.home.viewmodel.MoviesViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun MovieList(viewModel: MoviesViewModel = hiltViewModel()) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val movies = viewModel.movies.value.movie!!.flow.collectAsLazyPagingItems()

        if (viewModel.movies.value.isLoading) {
            CircularProgressIndicator()
        } else {

            TvLazyRow(
                content = {
                    items(movies.itemCount) { index ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(120.dp, 120.dp)
                        ) {
                            movies[index]?.let { MoviesItem(movie = it) }
                        }
                    }
                }
            )
        }
    }
}