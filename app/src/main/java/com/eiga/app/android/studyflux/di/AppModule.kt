package com.eiga.app.android.studyflux.di

import com.eiga.app.android.studyflux.data.repository.CatalogRepository
import com.eiga.app.android.studyflux.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { CatalogRepository(get()) }
    viewModel { ListViewModel(get()) }
}