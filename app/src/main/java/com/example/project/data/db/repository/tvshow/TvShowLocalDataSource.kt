package com.example.project.data.db.repository.tvshow


import com.example.project.model.Tv

interface TvShowLocalDataSource {
    suspend fun getTvFromDB():List<Tv>
    suspend fun saveTvFromDb(tvshows:List<Tv>)
    suspend fun clearAll()
}