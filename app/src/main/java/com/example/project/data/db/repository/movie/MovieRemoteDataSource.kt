package com.example.project.data.db.repository.movie

import com.example.project.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    //This should have a function which should return a a list of movie
    //Return type is same as we get from server
    suspend fun getMovies():Response<MovieList>
}