package com.example.project.presentation.di.core

import com.example.project.data.db.repository.MovieRepositoryImpl
import com.example.project.data.db.repository.TvShowRepositoryImpl
import com.example.project.data.db.repository.movie.MovieCachedDataSource
import com.example.project.data.db.repository.movie.MovieLocalDataSource
import com.example.project.data.db.repository.movie.MovieRemoteDataSource
import com.example.project.data.db.repository.tvshow.TvShowCachedDataSource
import com.example.project.data.db.repository.tvshow.TvShowLocalDataSource
import com.example.project.data.db.repository.tvshow.TvshowRemoteDataSource
import com.example.project.domain.repository.MovieRepository
import com.example.project.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    //Since we have already created module for datasource. It can directly access it.
    //Return types here are the interface name.
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCachedDataSource: MovieCachedDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCachedDataSource)
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvshowRemoteDataSource: TvshowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCachedDataSource: TvShowCachedDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(tvshowRemoteDataSource,tvShowLocalDataSource,tvShowCachedDataSource)
    }
}