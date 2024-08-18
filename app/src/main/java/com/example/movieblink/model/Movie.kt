package com.example.movieblink.model

data class Movie(
    val id: Int,
    val name: String,
    val releaseDate: String,
    val cast: List<String>,
    val description: String
)
