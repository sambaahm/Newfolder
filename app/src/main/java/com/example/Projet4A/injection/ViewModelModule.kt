package com.example.Projet4A.injection

import com.example.Projet4A.presentation.details.MovieDetailViewModel
import com.example.Projet4A.presentation.list.MovieListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val ViewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}