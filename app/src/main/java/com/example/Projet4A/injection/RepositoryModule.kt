package com.example.Projet4A.injection

import com.example.Projet4A.data.repository.MoviesRepository
import com.example.Projet4A.data.repository.MoviesRepositoryImpl
import org.koin.dsl.module.module

val RepositoryModule = module {
    factory { MoviesRepositoryImpl(get(), get()) as MoviesRepository }
}
