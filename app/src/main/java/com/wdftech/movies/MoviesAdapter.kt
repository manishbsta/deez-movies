package com.wdftech.movies

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wdftech.movies.models.Movie

class MoviesAdapter(private val context: Activity, private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewHolder = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // populate the data into the view
        val movie = movies[position]

        holder.title.text = movie.title
        holder.releaseYear.text = movie.year.toString()
        holder.rating.text = movie.rating
        Picasso.get().load(movie.thumbnail).into(holder.poster)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.moviePoster)
        val title: TextView = itemView.findViewById(R.id.movieTitle)
        val releaseYear: TextView = itemView.findViewById(R.id.movieReleaseYear)
        val rating: TextView = itemView.findViewById(R.id.movieRating)
    }
}