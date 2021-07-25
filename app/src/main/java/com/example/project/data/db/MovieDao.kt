package com.example.project.data.db

import androidx.room.*
import com.example.project.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<Movie>)


    @Query("Delete from popular_movies")
    suspend fun deleteAllMovies()

    //To get all movies from database table as a list
    @Query("Select * from popular_movies")
    suspend fun getAllMovies():List<Movie>
}