package com.example.project.data.db.repository.movie

import com.example.project.model.Movie

interface MovieCachedDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMovieListTOCache(movies:List<Movie>)
}