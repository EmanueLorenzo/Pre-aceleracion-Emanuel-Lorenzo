package com.emanuel.alkemychallenge.domain.usecases

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.emanuel.alkemychallenge.data.remote.repository.Repository
import com.emanuel.alkemychallenge.domain.entities.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPopularMoviesUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): LiveData<PagingData<Movie>> =
        //Obtiene las peliculas mas populares
        repository.getPopularMovies()
}