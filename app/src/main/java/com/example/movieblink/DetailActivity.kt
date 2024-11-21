package com.example.movieblink

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieblink.ApiService
import com.example.movieblink.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    private lateinit var tvMovieName: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvCast: TextView
    private lateinit var tvDetails: TextView
    private lateinit var btnAddToCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvMovieName = findViewById(R.id.tvMovieName)
        tvReleaseDate = findViewById(R.id.tvReleaseDate)
        tvCast = findViewById(R.id.tvCast)
        tvDetails = findViewById(R.id.tvSummary)
        btnAddToCart = findViewById(R.id.btnAddToCart)

        // Get movie ID from intent extras
        val movieId = intent.getIntExtra("MOVIE_ID", -1)

        if (movieId != -1) {
            fetchMovieDetails(movieId)
        }

        btnAddToCart.setOnClickListener {
            val movie = getCurrentMovie()
            if (movie != null) {
                addToCart(movie)
            } else {
                Toast.makeText(this, "Error: Movie not loaded", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private var currentMovie: Movie? = null

    private fun getCurrentMovie(): Movie? {
        return currentMovie
    }

    private fun fetchMovieDetails(movieId: Int) {
        val apiService = ApiService.create()
        apiService.getMovies().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    val movies = response.body()
                    val movie = movies?.find { it.id == movieId }
                    if (movie != null) {
                        currentMovie = movie
                        displayMovieDetails(movie)
                    } else {
                        tvMovieName.text = "Movie not found"
                    }
                } else {
                    tvMovieName.text = "Failed to load movie details"
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                tvMovieName.text = "Error: ${t.localizedMessage}"
            }
        })
    }

    private fun displayMovieDetails(movie: Movie) {
        tvMovieName.text = movie.name
        tvReleaseDate.text = "Release Date: ${movie.releaseDate}"
        tvCast.text = "Cast: ${movie.cast.joinToString(", ")}"
        tvDetails.text = movie.description
    }

    private fun addToCart(movie: Movie) {
        val sharedPreferences = getSharedPreferences("CartPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()

        // Retrieve existing cart items
        val storedItems = sharedPreferences.getStringSet("CART_ITEMS", mutableSetOf()) ?: mutableSetOf()

        // Add the current movie to the cart
        val movieJson = gson.toJson(movie)
        if (storedItems.contains(movieJson)) {
            Toast.makeText(this, "Movie already in cart", Toast.LENGTH_SHORT).show()
        } else {
            storedItems.add(movieJson)
            editor.putStringSet("CART_ITEMS", storedItems)
            editor.apply()
            Toast.makeText(this, "Movie added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}
