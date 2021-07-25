package com.example.project.data.db.repository.movie

import com.example.project.model.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesFromDb(movies:List<Movie>)
    suspend fun clearAll()
}