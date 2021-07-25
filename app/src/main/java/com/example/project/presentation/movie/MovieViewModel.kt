package com.example.project.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.project.domain.GetMovieUseCase
import com.example.project.domain.UpdateMovieUseCase

//From viewmodel we only invoke usecase functions i.e savemovieusecase and updatemovieusecase in our project
class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }
    fun updateMovieList() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }//This viewmodel class has constructor parameter so we need to create a viewmodel factory


}