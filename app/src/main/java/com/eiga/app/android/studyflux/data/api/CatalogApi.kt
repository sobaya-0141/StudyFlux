package com.eiga.app.android.studyflux.data.api

import com.eiga.app.android.studyflux.data.api.entity.CatalogResponseDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CatalogApi {

    @GET("catalog/v1")
    fun catalogSearch(@Query("key") key: String, @Query("keyword") keyword: String,
                      @Query("brand") brand: String?, @Query("format") format: String): Deferred<CatalogResponseDto>
}