package com.wdftech.movies.models

data class Movie(
    val rank: Int,
    val title: String,
    val description: String,
    val image: String,
    val bigImage: String,
    val genre: List<String>,
    val thumbnail: String,
    val rating: String,
    val id: String,
    val year: Int,
    val imdbid: String,
    val imdb_link: String,
)
