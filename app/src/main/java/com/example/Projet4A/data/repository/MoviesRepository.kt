package com.example.Projet4A.data.repository


import androidx.lifecycle.LiveData
import com.example.Projet4A.data.local.models.Movie

interface MoviesRepository {

    suspend fun getShowingMovies(): LiveData<List<Movie>>
    suspend fun getMovieDetail(movieId: String): LiveData<Movie>
    suspend fun getSimilarMovies(movieId: String): LiveData<List<Movie>>

    fun fetchFullMovieDetails(movieId: String, addedTime: Long)
    fun fetchMoreShowingMoviesFromDataSource(page: Int)

    val error: LiveData<String>
}