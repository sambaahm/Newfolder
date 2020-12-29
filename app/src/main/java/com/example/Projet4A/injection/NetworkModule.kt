package com.example.Projet4A.injection

import com.example.Projet4A.data.remote.*
import com.example.Projet4A.data.remote.iterceptors.ConnectivityInterceptor
import com.example.Projet4A.data.remote.iterceptors.ConnectivityInterceptorImpl
import org.koin.dsl.module.module

val NetworkModule = module {
    single { ConnectivityInterceptorImpl(get()) as ConnectivityInterceptor }
    single { MovieApi(get()) }
    single { MoviesDataSourceImpl(get()) as MoviesDataSource }

}