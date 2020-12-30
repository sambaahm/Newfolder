package com.example.Projet4A.injection

import com.example.Projet4A.presentation.details.MovieDetailViewModel
import com.example.Projet4A.presentation.list.MovieListViewModel
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel


import org.koin.dsl.module


val ViewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}