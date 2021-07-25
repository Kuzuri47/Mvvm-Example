package com.example.project.data.db.repository.tvshow


import com.example.project.model.TvList
import retrofit2.Response

interface TvshowRemoteDataSource {
    //This should have a function which should return a a list of movie
    //Return type is same as we get from server
    suspend fun getTvShow(): Response<TvList>
}