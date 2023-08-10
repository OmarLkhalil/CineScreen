package com.mobilebreakero.common.data.mapper

import android.util.Log
import com.mobilebreakero.common.data.dto.VideoDto
import com.mobilebreakero.common.data.dto.VideoItem
import com.mobilebreakero.common.domain.model.VideoItemModel
import com.mobilebreakero.common.domain.model.VideosModel
import javax.inject.Inject

class VideoMapper @Inject constructor(){

    fun fromRemoteToModel(obj: VideoDto): VideosModel{
        return VideosModel(
            videos = obj.results!!.map { fromRemoteObjectToModel(it!!) },
        )
    }
    private fun fromRemoteObjectToModel(obj: VideoItem): VideoItemModel {

        return VideoItemModel(
            id = obj.id,
            key = obj.key
        )
    }
}