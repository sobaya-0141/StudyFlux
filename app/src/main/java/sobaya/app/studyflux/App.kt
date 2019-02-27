package sobaya.app.studyflux

import android.app.Application
import sobaya.app.studyflux.di.appModule
import sobaya.module.data.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule) + listOf(appModule))
        }
    }
}