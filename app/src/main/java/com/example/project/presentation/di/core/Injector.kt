package com.example.project.presentation.di.core

import com.example.project.presentation.di.movies.MovieSubComponenet
import com.example.project.presentation.di.tvshows.TvShowSubComponent

interface Injector {
    fun createMoviesSubComponenet():MovieSubComponenet
    fun createTvShowSubComponenet():TvShowSubComponent
}