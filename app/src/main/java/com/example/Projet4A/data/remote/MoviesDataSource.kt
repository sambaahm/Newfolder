package com.example.Projet4A.data.remote



import androidx.lifecycle.LiveData
import com.example.Projet4A.data.local.models.Movie

interface MoviesDataSource {
    val showingMovies: LiveData<List<Movie>>
    val movieDetail: LiveData<Movie>
    val similarMovies: LiveData<List<Movie>>
    val error: LiveData<String>

    suspend fun getShowingMovies(page: Int)
    suspend fun getMovieDetail(id: String, addedTime: Long)
    suspend fun getSimilarMovies(id: String)
}