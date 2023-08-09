package com.mobilebreakero.common.domain.pagination_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobilebreakero.common.domain.model.MovieItem
import com.mobilebreakero.common.domain.repository.MoviesRepository

class MoviesPaginationSource(
    private val repository: MoviesRepository,
    val cateId: String,
    val lang: String
): PagingSource<Int, MovieItem>(){

    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        return try {
            val page = params.key ?: 1
            val response = repository.getMovies(language = lang, page = page, genresId = cateId)
            LoadResult.Page(
                data = response.movieList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.movieList.isEmpty()) null else page + 1
            )
        }
        catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}