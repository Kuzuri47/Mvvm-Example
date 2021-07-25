package com.example.project.data.db.repository.movie


import com.example.project.data.db.MovieDao
import com.example.project.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao):MovieLocalDataSource {
    //To work with local data source we need moviedao interface
    //When we are getting data from the room database room execute that query in background thread.For others we need
    //to use coroutines
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getAllMovies()
    }

    override suspend fun saveMoviesFromDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}