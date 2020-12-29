package com.example.Projet4A.di

import com.example.Projet4A.ui.details.MovieDetailViewModel
import com.example.Projet4A.ui.list.MovieListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val ViewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}