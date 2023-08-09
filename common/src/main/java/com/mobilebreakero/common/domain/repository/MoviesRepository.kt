package com.mobilebreakero.common.domain.repository

import com.mobilebreakero.common.domain.model.MoviesModel

interface MoviesRepository {

    suspend fun getMovies (language: String,page: Int,genresId:String): MoviesModel
}