package com.mobilebreakero.common.domain.usecase

import com.mobilebreakero.common.domain.model.GenresModel
import com.mobilebreakero.common.domain.repository.CatsRepository
import com.mobilebreakero.common.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(private val repository: CatsRepository) {

    operator fun invoke(lang: String): Flow<Resource<GenresModel>> = flow {
        try {
            emit(Resource.Loading())
            val getGenres = repository.getCategories(lang)
            emit(Resource.Success(getGenres))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "An unexpected error occured"))
        }
    }
}