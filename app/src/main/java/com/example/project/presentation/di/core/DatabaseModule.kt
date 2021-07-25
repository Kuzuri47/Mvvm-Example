package com.example.project.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.project.data.db.MovieDao
import com.example.project.data.db.TMDBDatabase
import com.example.project.data.db.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//This is database module
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideTvShow(tmdbDatabase: TMDBDatabase):TvDao{
        return tmdbDatabase.tvDao()
    }

}