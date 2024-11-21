package com.example.movieblink


import com.example.movieblink.model.Movie
import com.example.movieblink.model.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("272dad55-e7d7-4299-a6e5-65b7e9af20d9") // Replace with your actual endpoint
    fun getMovies(): Call<List<Movie>> // Get all movies

    // New method to fetch movies filtered by category
    @GET("272dad55-e7d7-4299-a6e5-65b7e9af20d9") // Use your actual endpoint
    fun getMoviesByCategory(@Query("category") category: String): Call<List<Movie>> // Filter by category

    companion object {
        private const val BASE_URL = "https://run.mocky.io/v3/"

        // Retrofit client initialization
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        // Create the ApiService instance
        fun create(): ApiService {
            return getClient().create(ApiService::class.java)
        }
    }
}
