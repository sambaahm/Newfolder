package com.example.Projet4A.data.remote

import android.arch.lifecycle.LiveData
import com.example.Projet4A.data.local.model.Movie

interface MoviesDataSource {
    val showingMovies: LiveData<List<Movie>>
    val movieDetail: LiveData<Movie>
    val similarMovies: LiveData<List<Movie>>
    val error: LiveData<String>

    suspend fun getShowingMovies(page: Int)
    suspend fun getMovieDetail(id: String, addedTime: Long)
    suspend fun getSimilarMovies(id: String)
}