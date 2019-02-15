package com.eiga.app.android.studyflux.data.repository

import com.eiga.app.android.studyflux.data.api.CatalogApi

class CatalogRepository(private val api: CatalogApi) {

    fun catalogSearch(keyword: String, brand: String?) = api.catalogSearch("API_KEY",
            keyword, brand, "json")
}