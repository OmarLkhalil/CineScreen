package com.mobilebreakero.common.data.remote

import com.mobilebreakero.common.data.Constants
import com.mobilebreakero.common.data.dto.GenreDto
import com.mobilebreakero.common.data.dto.MoviesDto
import com.mobilebreakero.common.data.dto.VideoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("genre/movie/list")
    suspend fun getCats(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en",
    ): GenreDto


    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("with_genres") genresId: String,
        @Query("page") page: Int,
        @Query("language") language: String = "en-US",
    ) : MoviesDto

    @GET("movie/{movie_id}/videos")
    suspend fun getVideoTrial(
        @Path("movie_id") movieId: String = "569094",
        @Query("language") language: String = "en-US",
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): VideoDto
}