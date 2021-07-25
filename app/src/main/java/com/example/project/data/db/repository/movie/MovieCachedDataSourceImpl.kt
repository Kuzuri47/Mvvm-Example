package com.example.project.data.db.repository.movie

import com.example.project.model.Movie

class MovieCachedDataSourceImpl:MovieCachedDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieListTOCache(movies: List<Movie>) {
       movieList.clear()
        movieList = ArrayList(movies)
    }

}