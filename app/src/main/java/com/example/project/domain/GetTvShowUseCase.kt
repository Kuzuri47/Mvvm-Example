package com.example.project.domain

import com.example.project.domain.repository.TvShowRepository
import com.example.project.model.Tv

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    //Now we can use the execute fun of usecase. UseCase class does not need to know abput the implemetation of method in repository.
    suspend fun execute():List<Tv>? = tvShowRepository.getTvshows()
}