package com.example.project.api


import com.example.project.model.MovieList
import com.example.project.model.TvList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")api_key:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTv(@Query("api_key")api_key:String):Response<TvList>
}