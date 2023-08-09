package com.mobilebreakero.common.domain.repository

import com.mobilebreakero.common.domain.model.GenresModel

interface CatsRepository {

    suspend fun getCategories(lang: String): GenresModel
}