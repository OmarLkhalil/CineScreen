package com.mobilebreakero.common.data.reposimpl

import com.mobilebreakero.common.data.mapper.GenreMapper
import com.mobilebreakero.common.data.remote.MoviesApi
import com.mobilebreakero.common.domain.model.GenresModel
import com.mobilebreakero.common.domain.repository.CatsRepository

class CategoriesRepositoryImplementation(private val api: MoviesApi, private val genreMapper: GenreMapper): CatsRepository {
    override suspend fun getCategories(lang: String): GenresModel {
        return genreMapper.fromRemoteToModel(api.getCats(language = lang))
    }
}