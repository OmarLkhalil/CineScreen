package com.mobilebreakero.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.common.domain.usecase.MoviesUseCase
import com.mobilebreakero.common.domain.util.MovieState
import com.mobilebreakero.common.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieUseCase: MoviesUseCase) : ViewModel() {

    private val _state = mutableStateOf(MovieState())
    val movies: State<MovieState>
        get() = _state

    init {
        getMovies(language = "en-US", genresId = "28")
    }

    fun getMovies(language: String, genresId: String) {
        movieUseCase(
            genresId = genresId,
            language = language,
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieState(movie = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        MovieState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    fun getMoviesByCategory(language: String, genresId: String) {
        movieUseCase(
            genresId = genresId,
            language = language,
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieState(movie = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        MovieState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}