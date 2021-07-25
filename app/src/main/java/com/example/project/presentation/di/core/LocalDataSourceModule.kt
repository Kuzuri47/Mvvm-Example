package com.example.project.presentation.di.core

import com.example.project.data.db.MovieDao
import com.example.project.data.db.TvDao
import com.example.project.data.db.repository.movie.MovieLocalDataSource
import com.example.project.data.db.repository.movie.MovieLocalDataSourceImpl
import com.example.project.data.db.repository.tvshow.TvShowLocalDataSource
import com.example.project.data.db.repository.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvLocalDataSource(tvDao: TvDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvDao)
    }
}