package com.example.Projet4A.presentation.list





import androidx.lifecycle.ViewModel
import com.example.Projet4A.data.repository.MoviesRepository
import com.example.Projet4A.services.lazyDeferred


class MovieListViewModel(private val moviesRepository: MoviesRepository): ViewModel() {

    val movies by lazyDeferred { moviesRepository.getShowingMovies() }
    val error = moviesRepository.error
    fun fetchMoreShowingMovies(page: Int) {
        moviesRepository.fetchMoreShowingMoviesFromDataSource(page)
    }
}