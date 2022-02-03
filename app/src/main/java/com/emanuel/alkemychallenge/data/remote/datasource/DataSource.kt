package com.emanuel.alkemychallenge.data.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.emanuel.alkemychallenge.data.TMDb
import com.emanuel.alkemychallenge.domain.entities.Movie
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

    //Inject
    //Identifies injectable constructors, methods, and fields. May apply to static as well as instance members.
    // An injectable member may have any access modifier (private, package-private, protected, public).

class DataSource @Inject constructor(
    private val api: IDataSource,
    private val query: String
) : PagingSource<Int, Movie>() {
    //PagingSource
    // Base class for an abstraction of pageable static data from some source, where loading
    // pages of data is typically an expensive operation. Some examples of common PagingSources might be
    // from network or from a database.
    constructor(api: IDataSource) : this(api, query = "")


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        //Provide a Key used for the initial load for the next PagingSource due to invalidation of
        // this PagingSource. The Key is provided to load via LoadParams.key.
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    //load
    //Loading API for PagingSource.
    //LoadParams
    //Params for a load request on a PagingSource


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        //load
        //load api
        val page = params.key ?: TMDb.starting_page_index
        //key
        // Key for the page to be loaded.

        return try {
            //hacemos un if else si el usuario ha ingresado algo en la consulta va y busca el nombre de la
            //pelicula por nombre si esta vacio muestra las peliculas mas populares
            val response = if (query.isNotEmpty() && query != "") {
                api.fetchMovieByName(TMDb.api_key, query, page)
            } else {
                api.fetchPopularMovies(TMDb.api_key, page)
            }
            val movies = response.body()?.movies!!
            //body The deserialized response body of a successful response.
            LoadResult.Page(
                //carga los resultados
                data = movies,
                prevKey = if (page == TMDb.starting_page_index) null else page - 1,
                nextKey = if (response.body()?.movies?.isEmpty()!!) null else page + 1
            )
        } catch (ex: IOException) {
            LoadResult.Error(ex)
        } catch (ex: HttpException) {
            LoadResult.Error(ex)
        }
    }

}