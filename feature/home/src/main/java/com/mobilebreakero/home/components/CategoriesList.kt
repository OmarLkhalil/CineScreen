package com.mobilebreakero.home.components


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mobilebreakero.common.domain.model.GenreItemModel
import com.mobilebreakero.home.viewmodel.CategoriesViewModel
import com.mobilebreakero.home.viewmodel.MoviesViewModel
import java.util.Locale

@SuppressLint("UnrememberedMutableState")
@Composable
fun GenreList(
    genreViewModel: CategoriesViewModel = hiltViewModel(),
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {
    val genres = genreViewModel.genres.value.genre

    if (genreViewModel.genres.value.isLoading) {
        CircularProgressIndicator()
    } else if (genres.isNotEmpty()) {
        Text(
            modifier = Modifier.padding(PaddingValues(8.dp)),
            text = "Filter By: ",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        LazyRow {
            itemsIndexed(genres) { index, genre ->
                Chip(
                    genre = genre,
                    selected = genreViewModel.selectedGenre.value == genre,
                    onSelected = {
                        if (genreViewModel.selectedGenre.value == genre)
                            genreViewModel.setSelectedGenre(GenreItemModel())
                        else
                            genreViewModel.setSelectedGenre(genre)
                    },
                    modifier = Modifier
                )

                if (index == 0 && genreViewModel.selectedGenre.value.name.isEmpty()) {
                    if (genre.id.toInt() == 28) {
                        genreViewModel.setSelectedGenre(genre)
                    }
                }
            }
        }
        if (genreViewModel.selectedGenre.value.name.isNotEmpty()) {
            moviesViewModel.getMoviesByCategory(
                Locale.getDefault().language,
                genreViewModel.selectedGenre.value.id.toString()
            )
            MovieList()
        }
    }
}
