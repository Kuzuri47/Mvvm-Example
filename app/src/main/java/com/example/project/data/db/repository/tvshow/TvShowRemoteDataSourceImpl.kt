package com.example.project.data.db.repository.tvshow

import com.example.project.api.TMDBService
import com.example.project.model.TvList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):TvshowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvList> {
        return tmdbService.getPopularTv(apiKey)
    }
}