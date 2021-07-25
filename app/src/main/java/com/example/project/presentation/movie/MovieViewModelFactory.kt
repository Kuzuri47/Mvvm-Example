package com.example.project.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.domain.GetMovieUseCase
import com.example.project.domain.UpdateMovieUseCase

class MovieViewModelFactory(private val getMovieUseCase: GetMovieUseCase,
private val updateMovieUseCase: UpdateMovieUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMovieUseCase) as T
    }
}