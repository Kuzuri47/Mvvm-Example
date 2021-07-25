package com.example.project.data.db.repository

import android.util.Log
import com.example.project.data.db.repository.tvshow.TvShowCachedDataSource
import com.example.project.data.db.repository.tvshow.TvShowLocalDataSource
import com.example.project.data.db.repository.tvshow.TvshowRemoteDataSource
import com.example.project.domain.repository.TvShowRepository
import com.example.project.model.Movie
import com.example.project.model.Tv
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvshowRemoteDataSource: TvshowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCachedDataSource: TvShowCachedDataSource
) : TvShowRepository {
    override suspend fun getTvshows(): List<Tv>? {
       return getTvFromCache()
    }

    override suspend fun updateTvsHows(): List<Tv>? {
        val newListOfTv = gettvFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvFromDb(newListOfTv)
        tvShowCachedDataSource.saveTvToCache(newListOfTv)
        return newListOfTv
    }

    //Movies From Remote Data source

    suspend fun gettvFromApi():List<Tv>{
        lateinit var tvShowList:List<Tv>

        try{
            val response = tvshowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvs
            }
        }catch (exception: Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return tvShowList
    }
    //Movie From Database

    suspend fun getTvFromDb():List<Tv>{
        lateinit var tvShowList:List<Tv>

        try{
            tvShowList = tvShowLocalDataSource.getTvFromDB()

        }catch (exception: Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = gettvFromApi()
            tvShowLocalDataSource.saveTvFromDb(tvShowList)
        }
        return tvShowList
    }

    //Movies from Cache

    suspend fun getTvFromCache():List<Tv>{
        lateinit var tvShowList:List<Tv>

        try{
            tvShowList = tvShowCachedDataSource.getTvShowsFromCache()

        }catch (exception: Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvFromDb()
            tvShowCachedDataSource.saveTvToCache(tvShowList)
        }
        return tvShowList
    }
}