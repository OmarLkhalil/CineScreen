package com.mobilebreakero.common.data.reposimpl

import com.mobilebreakero.common.data.mapper.MoviesMapper
import com.mobilebreakero.common.data.remote.MoviesApi
import com.mobilebreakero.common.domain.model.MoviesModel
import com.mobilebreakero.common.domain.repository.MoviesRepository
import javax.inject.Inject


class MoviesRepositoryImplementation @Inject constructor(
    private val api: MoviesApi,
    private val movieMapper: MoviesMapper,
) : MoviesRepository {
    override suspend fun getMovies(language: String, page: Int, genresId: String): MoviesModel {
        return movieMapper.fromRemoteMoviesToMoviesModel(api.getMovies(language = language, page = page, genresId = genresId))
    }
}