package com.mobilebreakero.common.domain.model

data class VideosModel(
    val videos : List<VideoItemModel> = emptyList(),
)

data class VideoItemModel(
    var id : String? = null,
    val key : String? = null,
)