package com.example.Projet4A.data.api.responses

import com.google.gson.annotations.SerializedName
import com.example.Projet4A.data.db.model.Movie

data class MovieListResponse(
    @SerializedName("pages") val pages: Int,
    @SerializedName("results") val movies: List<Movie>)