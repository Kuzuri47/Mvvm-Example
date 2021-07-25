package com.example.project.presentation.di.core

import com.example.project.data.db.repository.movie.MovieCachedDataSource
import com.example.project.data.db.repository.movie.MovieCachedDataSourceImpl
import com.example.project.data.db.repository.tvshow.TvShowCachedDataSource
import com.example.project.data.db.repository.tvshow.TvShowCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CachedDataModule {
    @Singleton
    @Provides
    fun provideMovieCachedDataSource():MovieCachedDataSource{
        return MovieCachedDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideTvShowCachedDataSource():TvShowCachedDataSource{
        return TvShowCachedDataSourceImpl()
    }
}