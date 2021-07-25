package com.example.project.domain

import com.example.project.domain.repository.MovieRepository
import com.example.project.model.Movie

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    //Now we can use the execute fun of usecase. UseCase class does not need to know abput the implemetation of method in repository.
    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}