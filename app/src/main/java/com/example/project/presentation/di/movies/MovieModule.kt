package com.example.project.presentation.di.movies

import com.example.project.domain.GetMovieUseCase
import com.example.project.domain.GetTvShowUseCase
import com.example.project.domain.UpdateMovieUseCase
import com.example.project.presentation.movie.MovieViewModel
import com.example.project.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

//These are subclass
//After this create a dagger scope


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase):MovieViewModelFactory{
        return MovieViewModelFactory(getMovieUseCase,updateMovieUseCase)
    }
}