package com.mobilebreakero.common.data.reposimpl

import com.mobilebreakero.common.data.mapper.VideoMapper
import com.mobilebreakero.common.data.remote.MoviesApi
import com.mobilebreakero.common.domain.model.VideosModel
import com.mobilebreakero.common.domain.repository.VideoRepository
import javax.inject.Inject

class VideosRepoImplementation @Inject constructor(
    private val videoMapper: VideoMapper,
    private val videoService: MoviesApi
): VideoRepository {
    override suspend fun getVideos(movieId: String?) : VideosModel {
        return videoMapper.fromRemoteToModel(videoService.getVideoTrial(movieId = movieId!!))
    }
}