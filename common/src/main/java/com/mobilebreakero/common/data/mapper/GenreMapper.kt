package com.mobilebreakero.common.data.mapper

import com.mobilebreakero.common.data.dto.GenreDto
import com.mobilebreakero.common.data.dto.GenreItemDto
import com.mobilebreakero.common.domain.model.GenreItemModel
import com.mobilebreakero.common.domain.model.GenresModel
import javax.inject.Inject

class GenreMapper @Inject constructor() {

    fun fromRemoteToModel(obj: GenreDto): GenresModel{
        return GenresModel(
            genres = obj.genres.map { fromRemoteObjectToModel(it) }
        )
    }

    private fun fromRemoteObjectToModel(obj: GenreItemDto): GenreItemModel{
        return GenreItemModel(
            id = obj.id,
            name = obj.name
        )
    }
}