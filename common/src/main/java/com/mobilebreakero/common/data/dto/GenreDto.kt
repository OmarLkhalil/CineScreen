package com.mobilebreakero.common.data.dto

data class GenreDto(
    val genres: ArrayList<GenreItemDto>,
)

data class GenreItemDto(
    val id: Long,
    val name: String,
)
