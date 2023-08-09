package com.mobilebreakero.common.domain.model

data class GenresModel(
    val genres : List<GenreItemModel> = emptyList(),
)

data class GenreItemModel(
    val id : Long = -1,
    val name : String = "",
)