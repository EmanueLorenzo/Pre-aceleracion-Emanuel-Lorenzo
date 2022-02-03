package com.emanuel.alkemychallenge.domain.entities


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
//En esta clase estan los datos relacionados a las peliculas q
//Cada pelicula tiene un ID,idioma original,titulo original,popularidad,fecha de estreno,votos,etc
data class Movie(
    @SerializedName("backdrop_path") val backdropPath :String,
    @SerializedName("id") val id :Int,
    @SerializedName("original_language") val originalLanguage :String,
    @SerializedName("original_title") val originalTitle :String,
    @SerializedName("overview") val overview :String,
    @SerializedName("popularity") val popularity :Double,
    @SerializedName("poster_path") val posterPath :String,
    @SerializedName("release_date") val releaseDate :String,
    @SerializedName("title") val title :String,
    @SerializedName("vote_average") val voteAverage :Double,
    @SerializedName("vote_count") val voteCount :Int
) : Parcelable