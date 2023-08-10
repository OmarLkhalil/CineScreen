package com.mobilebreakero.moviesapp.di

import com.mobilebreakero.common.data.mapper.GenreMapper
import com.mobilebreakero.common.data.mapper.MoviesMapper
import com.mobilebreakero.common.data.mapper.VideoMapper
import com.mobilebreakero.common.data.remote.MoviesApi
import com.mobilebreakero.common.data.reposimpl.CategoriesRepositoryImplementation
import com.mobilebreakero.common.data.reposimpl.MoviesRepositoryImplementation
import com.mobilebreakero.common.data.reposimpl.VideosRepoImplementation
import com.mobilebreakero.common.domain.repository.CatsRepository
import com.mobilebreakero.common.domain.repository.MoviesRepository
import com.mobilebreakero.common.domain.repository.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(api: MoviesApi, mapper: MoviesMapper): MoviesRepository{
        return MoviesRepositoryImplementation(api, mapper)
    }

    @Provides
    @Singleton
    fun provideCategoriesRepository(api: MoviesApi, mapper: GenreMapper): CatsRepository{
        return CategoriesRepositoryImplementation(api, mapper)
    }

    @Provides
    @Singleton
    fun provideVideoRepository(api: MoviesApi, mapper: VideoMapper): VideoRepository {
        return VideosRepoImplementation(mapper, api)
    }
}