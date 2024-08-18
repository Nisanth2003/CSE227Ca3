package com.example.movieblink

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.movieblink.model.Movie
import com.example.movieblink.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity() {

    private lateinit var tvMovieName: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvCast: TextView
    private lateinit var tvDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        tvMovieName = findViewById(R.id.tvMovieName)
        tvReleaseDate = findViewById(R.id.tvReleaseDate)
        tvCast = findViewById(R.id.tvCast)
        tvDetails = findViewById(R.id.tvSummary)

        // Get movie ID from intent extras
        val movieId = intent.getIntExtra("MOVIE_ID", -1)
        if (movieId != -1) {
            fetchMovieDetails(movieId)
        }
    }

    private fun fetchMovieDetails(movieId: Int) {
        val apiService = ApiService.create()
        apiService.getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    val movie = movieResponse?.movies?.find { it.id == movieId }
                    if (movie != null) {
                        displayMovieDetails(movie)
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

    private fun displayMovieDetails(movie: Movie) {
        tvMovieName.text = movie.name
        tvReleaseDate.text = "Release Date: ${movie.releaseDate}"
        tvCast.text = "Cast: ${movie.cast.joinToString(", ")}"
        tvDetails.text = movie.description
    }
}

