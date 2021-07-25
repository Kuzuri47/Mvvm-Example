package com.example.project.domain

import com.example.project.domain.repository.TvShowRepository
import com.example.project.model.Tv

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<Tv>? = tvShowRepository.updateTvsHows()
}