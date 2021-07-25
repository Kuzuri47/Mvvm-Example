package com.example.project.domain

import com.example.project.domain.repository.MovieRepository
import com.example.project.model.Movie

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}