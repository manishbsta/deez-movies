package com.wdftech.movies.services

import com.wdftech.movies.models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: YOUR_RAPID_API_KEY",
        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"
    )
    @GET("/")
    fun fetchTop100Movies(): Call<List<Movie>>
}