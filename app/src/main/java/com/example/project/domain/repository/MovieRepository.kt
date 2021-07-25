package com.example.project.domain.repository

import com.example.project.model.Movie

interface MovieRepository {
    //Here we need to define an abstract function which returns a list of movies
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}