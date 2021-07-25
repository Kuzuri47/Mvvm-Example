package com.example.project.domain.repository

import com.example.project.model.Tv

interface TvShowRepository {
    //Here we need to define an abstract function which returns a list of movies
    suspend fun getTvshows():List<Tv>?
    suspend fun updateTvsHows():List<Tv>?
}