package com.example.Projet4A.injection

import com.example.Projet4A.data.repository.MoviesRepository

import org.koin.dsl.module


val RepositoryModule = module {
    //factory { MoviesRepositoryImpl(get(), get()) as MoviesRepository }
}
