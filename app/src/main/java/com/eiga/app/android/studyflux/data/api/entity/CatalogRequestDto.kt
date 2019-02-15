package com.eiga.app.android.studyflux.data.api.entity

import com.squareup.moshi.Json

data class CatalogRequestDto(
    val key: String,
    val keyword: String?,
    @Json(name = "year_old")
    val yearOld: Int?,
    @Json(name = "year_new")
    val yearNew: Int?,
    val format: String
)