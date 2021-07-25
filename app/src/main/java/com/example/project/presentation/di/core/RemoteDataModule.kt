package com.example.project.presentation.di.core

import com.example.project.api.TMDBService
import com.example.project.data.db.repository.movie.MovieRemoteDataSource
import com.example.project.data.db.repository.movie.MovieRemoteDataSourceImpl
import com.example.project.data.db.repository.tvshow.TvShowRemoteDataSourceImpl
import com.example.project.data.db.repository.tvshow.TvshowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apikey)
    }
    @Singleton
    @Provides
    fun providetvRemoteDataSource(tmdbService: TMDBService):TvshowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,apikey)
    }
}