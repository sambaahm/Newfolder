package com.example.Projet4A.di

import com.example.Projet4A.data.db.MoviesDatabase
import org.koin.dsl.module.module

val  DatabaseModule = module {
    single { MoviesDatabase.getInstance(get()) }
    single { get<MoviesDatabase>().moviesDao() }
}
/*commitoements*/