package com.example.project.data.db.repository.movie

import com.example.project.api.TMDBService
import com.example.project.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService:TMDBService,private val apiKey:String):MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
       return tmdbService.getPopularMovies(apiKey)
    }
}