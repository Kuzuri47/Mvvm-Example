package com.example.project.presentation.di.core

import com.example.project.domain.GetMovieUseCase
import com.example.project.domain.GetTvShowUseCase
import com.example.project.domain.UpdateMovieUseCase
import com.example.project.domain.UpdateTvShowUseCase
import com.example.project.domain.repository.MovieRepository
import com.example.project.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMovieUseCase{
        return GetMovieUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }
    @Provides
    fun provideFetTvUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }
}