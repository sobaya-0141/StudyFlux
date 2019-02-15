package com.eiga.app.android.studyflux.di

import com.eiga.app.android.studyflux.data.api.CatalogApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

val networkModule = module {
    single { createMoshi() }
    single { createOkHttp() }
    single { createRetrofit(get(), get()) }
    single<CatalogApi> { createApi(get())}
}

fun createMoshi() = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .add(KotlinJsonAdapterFactory())
        .build()


fun createOkHttp(): OkHttpClient {

    val builder = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()

    logging.level = if (BuildConfig.BUILD_TYPE == "debug") HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    builder.addInterceptor(logging)

    return builder.build()
}

fun createRetrofit(okHttpClient: OkHttpClient, moshi: Moshi) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://webservice.recruit.co.jp/carsensor/")
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

fun createApi(retrofit: Retrofit) = retrofit.create(CatalogApi::class.java)