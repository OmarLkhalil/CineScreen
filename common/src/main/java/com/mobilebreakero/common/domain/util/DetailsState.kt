package com.mobilebreakero.common.domain.util

import com.mobilebreakero.common.domain.model.VideoItemModel

data class DetailsState(
    val isLoading: Boolean = false,
    val video: List<VideoItemModel> = emptyList(),
    val error: String = ""
)