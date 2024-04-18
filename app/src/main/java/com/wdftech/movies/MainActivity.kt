package com.wdftech.movies

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wdftech.movies.models.Movie
import com.wdftech.movies.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var movieListRecyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListRecyclerView = findViewById(R.id.moviesRV)

        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://imdb-top-100-movies.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val response = retrofitClient.fetchTop100Movies()

        response.enqueue(object : Callback<List<Movie>?> {
            override fun onResponse(call: Call<List<Movie>?>, response: Response<List<Movie>?>) {
                val movies = response.body()
                moviesAdapter = MoviesAdapter(this@MainActivity, movies!!)
                movieListRecyclerView.adapter = moviesAdapter
                movieListRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<List<Movie>?>, t: Throwable) {
                Log.d("TAG: onFailure", t.toString())
            }
        })
    }
}