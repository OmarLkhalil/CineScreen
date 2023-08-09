package com.mobilebreakero.common.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mobilebreakero.common.domain.model.MovieItem
import com.mobilebreakero.common.domain.pagination_source.MoviesPaginationSource
import com.mobilebreakero.common.domain.repository.MoviesRepository
import com.mobilebreakero.common.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    operator fun invoke(
        language: String,
        genresId: String
    ): Flow<Resource<Pager<Int, MovieItem>>> = flow {

        try {
            emit(Resource.Loading())
            val getMovies = Pager(
                config = PagingConfig(pageSize = 10),
                pagingSourceFactory = {
                    MoviesPaginationSource(
                        repository = repository,
                        cateId = genresId,
                        lang = language
                    )
                }
            )
            emit(Resource.Success(getMovies))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "An unexpected error occured"))
        }
    }

}