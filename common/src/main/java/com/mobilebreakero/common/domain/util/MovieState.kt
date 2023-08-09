package com.mobilebreakero.common.domain.util

import androidx.paging.Pager
import com.mobilebreakero.common.domain.model.MovieItem

data class MovieState(
    val isLoading: Boolean = false,
    val movie: Pager<Int, MovieItem>? = null,
    val error: String = ""
)