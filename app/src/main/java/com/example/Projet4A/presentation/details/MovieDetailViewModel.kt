package com.example.Projet4A.presentation.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.Projet4A.data.repository.MoviesRepository

import com.example.Projet4A.data.local.models.Movie
import com.example.Projet4A.services.lazyDeferred


class MovieDetailViewModel(private val moviesRepository: MoviesRepository): ViewModel() {
    private lateinit var movieId: String
    private var addedTime: Long = 0

    suspend fun getMovieDetail(movieId: String): LiveData<Movie> {
        moviesRepository.getMovieDetail(movieId).observeForever {
            if (it?.status == null) {
                moviesRepository.fetchFullMovieDetails(movieId, addedTime)
            }
        }
       return moviesRepository.getMovieDetail(movieId)
    }

    fun setCurrentMovieData(id: String, addedTime: Long) {
        movieId = id
        this.addedTime = addedTime
    }

    val error = moviesRepository.error

    val similarMovies by lazyDeferred { moviesRepository.getSimilarMovies(movieId = movieId)}

}