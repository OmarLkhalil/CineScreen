package com.mobilebreakero.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.common.domain.model.GenreItemModel
import com.mobilebreakero.common.domain.usecase.CategoriesUseCase
import com.mobilebreakero.common.domain.util.GenreState
import com.mobilebreakero.common.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val catsUseCase: CategoriesUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(GenreState())
    private var _selectedGenre = mutableStateOf(GenreItemModel())

    val genres: State<GenreState>
        get() = _state

    val selectedGenre: State<GenreItemModel>
        get() = _selectedGenre

    fun setSelectedGenre(selectedGenre: GenreItemModel) {
        _selectedGenre.value = selectedGenre
        _selectedGenre.value = _selectedGenre.value
    }

    init {
        getGenre()
    }

    private fun getGenre() {
        catsUseCase(lang = Locale.getDefault().language).onEach { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = GenreState(
                        genre = result.data?.genres ?: emptyList()
                    )

                }

                is Resource.Error -> {
                    _state.value = GenreState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }

                is Resource.Loading -> {
                    _state.value = GenreState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}