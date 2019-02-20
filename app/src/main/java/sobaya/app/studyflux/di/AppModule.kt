package sobaya.app.studyflux.di

import org.koin.dsl.module
import sobaya.app.studyflux.data.repository.GithubRepository
import sobaya.app.studyflux.feature.list.ListActionCretor
import sobaya.app.studyflux.feature.list.ListStore
import sobaya.app.studyflux.flux.Dispatcher

val appModule = module {
    single { GithubRepository(get()) }
    single { Dispatcher() }
    single { ListStore(get()) }
    single { ListActionCretor(get(), get()) }
}