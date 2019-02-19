package sobaya.app.studyflux.di

import sobaya.app.studyflux.data.repository.GithubRepository
import sobaya.app.studyflux.feature.list.ListActionCretor
import sobaya.app.studyflux.feature.list.ListDispatcher
import sobaya.app.studyflux.feature.list.ListStore
import org.koin.dsl.module

val appModule = module {
    single { GithubRepository(get()) }
    single { ListDispatcher() }
    single { ListStore(get()) }
    single { ListActionCretor(get(), get()) }
}