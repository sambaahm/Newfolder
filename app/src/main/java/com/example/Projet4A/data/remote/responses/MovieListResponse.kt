package com.example.Projet4A.data.remote.responses

import com.google.gson.annotations.SerializedName
import com.example.Projet4A.data.local.model.Movie

data class MovieListResponse(
    @SerializedName("pages") val pages: Int,
    @SerializedName("results") val movies: List<Movie>)