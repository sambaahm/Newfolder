package com.example.Projet4A.di

import com.example.Projet4A.data.api.*
import com.example.Projet4A.data.api.iterceptors.ConnectivityInterceptor
import com.example.Projet4A.data.api.iterceptors.ConnectivityInterceptorImpl
import org.koin.dsl.module.module

val NetworkModule = module {
    single { ConnectivityInterceptorImpl(get()) as ConnectivityInterceptor }
    single { MovieApi(get()) }
    single { MoviesDataSourceImpl(get()) as MoviesDataSource }

}