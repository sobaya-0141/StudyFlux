package com.eiga.app.android.studyflux.data.api.entity

import com.squareup.moshi.Json

data class ResultsDto(
    @Json(name = "results_available")
    val available: Int,
    @Json(name = "results_returned")
    val returned: Int,
    val catalog: List<CatalogDto>
)