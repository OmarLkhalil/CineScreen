package com.mobilebreakero.common.domain.util

import com.mobilebreakero.common.domain.model.GenreItemModel

data class GenreState(
    val isLoading: Boolean = false,
    val genre: List<GenreItemModel> = emptyList(),
    val error: String = ""
)