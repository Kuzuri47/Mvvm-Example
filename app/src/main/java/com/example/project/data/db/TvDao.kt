package com.example.project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.project.model.Tv

@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTv(tvShows:List<Tv>)


    @Query("Delete from popular_tvshows")
    suspend fun deleteAllTvshows()

    //To get all tvSHow from database table as a list
    @Query("Select * from popular_tvshows")
    suspend fun getAllTvshows():List<Tv>
}