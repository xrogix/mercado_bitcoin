package com.mercadobitcoin.di

import android.content.Context
import com.mercadobitcoin.data.coroutines.NetworkResponseAdapterFactory
import com.mercadobitcoin.domain.usecase.GetExchangeByIdUseCase
import com.mercadobitcoin.BuildConfig
import com.mercadobitcoin.data.Api
import com.mercadobitcoin.data.repository.ExchangeRepositoryImpl
import com.mercadobitcoin.domain.repository.ExchangeRepository
import com.mercadobitcoin.domain.usecase.GetAllExchangesUseCase
import com.mercadobitcoin.presentation.screens.ListExchangeViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

val appModule = module {

    factoryOf(::ExchangeRepositoryImpl) { bind<ExchangeRepository>() }

    factoryOf(::GetAllExchangesUseCase)

    factoryOf(::GetExchangeByIdUseCase)

    single {
        provideRetrofit(
            okHttpClient = get(),
            moshi = get()
        )
    }

    single { provideOkhttp(get()) }

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    viewModelOf(::ListExchangeViewModel)

}

private fun provideOkhttp(
    context: Context
): OkHttpClient {
    val cacheSize = 10 * 1024 * 1024 // 10 MB
    return OkHttpClient
        .Builder()
        .cache(Cache(context.cacheDir, cacheSize.toLong()))
        .addInterceptor {
            val original: Request = it.request()

            val request = original.newBuilder()
                .addHeader("X-CoinAPI-Key", BuildConfig.API_KEY)
                .build()

            it.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        ))
        .build()
}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshi: Moshi
): Api {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(NetworkResponseAdapterFactory(moshi))
        .client(okHttpClient)
        .build()
        .create(Api::class.java)
}