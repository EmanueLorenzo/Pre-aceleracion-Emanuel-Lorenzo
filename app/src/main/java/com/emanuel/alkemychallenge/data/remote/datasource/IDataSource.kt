package com.emanuel.alkemychallenge.data.remote.datasource

import com.emanuel.alkemychallenge.data.remote.entities.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("movie/popular?")
    //Pelicula mas popular
    //Suspending functions are at the center of everything coroutines. A suspending function is
    // simply a function that can be paused and resumed at a later time. They can execute a long
    // running operation and wait for it to complete without blocking.
    //busca las peliculas mas populares
    suspend fun fetchPopularMovies(@Query("api_key") api_key: String,  @Query("page") page: Int): Response<MovieResponse>
    //Buscar la pelicula
    @GET("search/movie?")
    suspend fun fetchMovieByName(@Query("api_key") api_key: String, @Query("query") query: String, @Query("page") page: Int): Response<MovieResponse>
}