package com.emanuel.alkemychallenge.data.remote.entities

import com.emanuel.alkemychallenge.domain.entities.Movie
import com.google.gson.annotations.SerializedName


data class MovieResponse (
    @SerializedName("page") val page:Int,
    //Pagina
    @SerializedName("results") val movies:List<Movie>,
    //Resultados
    @SerializedName("total_pages") val totalPages:Int,
    //El total de las paginas
    @SerializedName("total_results") val totalResult:Int
    //El total de los resultados

)