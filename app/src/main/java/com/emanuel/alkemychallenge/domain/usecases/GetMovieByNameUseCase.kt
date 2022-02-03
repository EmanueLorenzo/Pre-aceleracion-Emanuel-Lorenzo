package com.emanuel.alkemychallenge.domain.usecases

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.emanuel.alkemychallenge.data.remote.repository.Repository
import com.emanuel.alkemychallenge.domain.entities.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//Identifies a type that the injector only instantiates once. Not inherited.
class GetMovieByNameUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(query: String): LiveData<PagingData<Movie>> =
        //Obtiene las peliculas por su nombre
        repository.getMovieByName(query)
}