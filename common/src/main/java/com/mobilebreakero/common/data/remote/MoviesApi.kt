package com.mobilebreakero.common.data.remote

import com.mobilebreakero.common.data.Constants
import com.mobilebreakero.common.data.dto.GenreDto
import com.mobilebreakero.common.data.dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("genre/movie/list?api_key=${Constants.API_KEY}")
    suspend fun getCats(
        @Query("language") language: String = "en",
    ): GenreDto


    @GET("discover/movie?api_key=${Constants.API_KEY}")
    suspend fun getMovies(
        @Query("with_genres") genresId: String,
        @Query("page") page: Int,
        @Query("language") language: String = "en-US",
    ) : MoviesDto
}