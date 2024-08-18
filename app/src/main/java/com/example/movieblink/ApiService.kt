package com.example.movieblink

import com.example.movieblink.model.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("5f6d1b36-3a96-4fae-a5da-0cea598c026c") // Endpoint for the movies JSON
    fun getMovies(): Call<MovieResponse>

    companion object {
        private const val BASE_URL = "https://run.mocky.io/v3/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}