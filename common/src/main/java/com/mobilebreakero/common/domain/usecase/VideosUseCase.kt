package com.mobilebreakero.common.domain.usecase

import com.mobilebreakero.common.domain.model.VideosModel
import com.mobilebreakero.common.domain.repository.VideoRepository
import com.mobilebreakero.common.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VideosUseCase @Inject constructor(private val repository: VideoRepository) {

    operator fun invoke(
        movieId: String?
    ) : Flow<Resource<VideosModel>> = flow{
        try {
            emit(Resource.Loading())
            val getVideos = repository.getVideos(movieId = movieId)
            emit(Resource.Success(getVideos))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "An unexpected error occured"))
        }
    }
}