package com.eiga.app.android.studyflux.data.api.entity

data class CatalogDto (
    val brand: BrandDto,
    val model: String,
    val grade: String,
    val price: Int,
    val desc: String,
    val body: BodyDto,
    val person: Int,
    val period: String,
    val series: String,
    val width: Int,
    val height: Int,
    val length: Int,
    val photo: PhotoDto
)