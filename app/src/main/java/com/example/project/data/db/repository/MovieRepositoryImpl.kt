package com.example.project.data.db.repository

import android.util.Log
import com.example.project.data.db.repository.movie.MovieCachedDataSource
import com.example.project.data.db.repository.movie.MovieLocalDataSource
import com.example.project.data.db.repository.movie.MovieRemoteDataSource
import com.example.project.domain.repository.MovieRepository
import com.example.project.model.Movie
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCachedDataSource: MovieCachedDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesFromDb(newListOfMovie)
        movieCachedDataSource.saveMovieListTOCache(newListOfMovie)
        return newListOfMovie
    }
    //Movies From Remote Data source

    suspend fun getMoviesFromApi():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return movieList
    }
    //Movie From Database

    suspend fun getMoviesFromDb():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesFromDb(movieList)
        }
        return movieList
    }

    //Movies from Cache

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            movieList = movieCachedDataSource.getMoviesFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDb()
            movieCachedDataSource.saveMovieListTOCache(movieList)
        }
        return movieList
    }

}