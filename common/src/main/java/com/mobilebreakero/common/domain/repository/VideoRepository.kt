package com.mobilebreakero.common.domain.repository

import com.mobilebreakero.common.domain.model.VideosModel

interface VideoRepository{

    suspend fun getVideos(movieId: String?): VideosModel

}