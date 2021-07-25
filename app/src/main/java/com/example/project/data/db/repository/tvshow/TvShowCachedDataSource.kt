package com.example.project.data.db.repository.tvshow


import com.example.project.model.Tv

interface TvShowCachedDataSource {
    suspend fun getTvShowsFromCache():List<Tv>
    suspend fun saveTvToCache(tvshow:List<Tv>)
}