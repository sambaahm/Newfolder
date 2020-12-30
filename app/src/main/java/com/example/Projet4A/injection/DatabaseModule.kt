package com.example.Projet4A.injection

import com.example.Projet4A.data.local.MoviesDatabase
import org.koin.dsl.module


val  DatabaseModule = module {
    single { MoviesDatabase.getInstance(get()) }
    single { get<MoviesDatabase>().moviesDao() }
}
