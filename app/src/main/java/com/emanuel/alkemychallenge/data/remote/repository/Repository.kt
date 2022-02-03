package com.emanuel.alkemychallenge.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.emanuel.alkemychallenge.data.remote.datasource.IDataSource
import com.emanuel.alkemychallenge.data.remote.datasource.DataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: IDataSource
) {
    fun getMovieByName(query: String) =
        Pager(
            config = PagingConfig(
                //define la cantidad de peliculas cargados por pagina
                pageSize = 20,
                //define la  maxima cantidad de peliculas cargadas por pagina
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { DataSource(api, query) }
        ).liveData
    //A LiveData of PagingData, which mirrors the stream provided by Pager.flow, but exposes it as a LiveData.
    fun getPopularMovies() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                //define la cantidad de peliculas mas populares cargadas por pagina
                maxSize = 100,
                //define la  maxima cantidad de peliculas mas populares cargadas por pagina
                enablePlaceholders = false
            ),
            pagingSourceFactory = { DataSource(api) }
        ).liveData


}