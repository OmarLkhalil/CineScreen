package com.mobilebreakero.common.data.mapper

import com.mobilebreakero.common.data.dto.MoviesDto
import com.mobilebreakero.common.data.dto.ResultsItem
import com.mobilebreakero.common.domain.model.MovieItem
import com.mobilebreakero.common.domain.model.MoviesModel
import javax.inject.Inject

class MoviesMapper @Inject constructor() {

    fun fromRemoteMoviesToMoviesModel(obj: MoviesDto): MoviesModel {
        return MoviesModel(
            movieList = fromRemoteMovieItemDtoToMovieItem(obj.results),
            page = obj.page,
            totalPages = obj.totalPages,
            totalResults = obj.totalResults
        )
    }

    fun fromRemoteMovieItemDtoToMovieItem(obj: List<ResultsItem?>?): List<MovieItem> {
        return obj!!.map {
            MovieItem(
                id = it!!.id,
                posterUrl = it.posterPath,
                name = it.title
            )
        }
    }
}