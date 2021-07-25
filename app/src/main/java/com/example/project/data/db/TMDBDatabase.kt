package com.example.project.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project.model.Movie
import com.example.project.model.Tv

@Database(entities = [Movie::class, Tv::class],version = 1,exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}