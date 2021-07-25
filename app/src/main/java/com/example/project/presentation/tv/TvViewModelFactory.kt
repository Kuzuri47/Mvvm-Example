package com.example.project.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.domain.GetTvShowUseCase
import com.example.project.domain.UpdateTvShowUseCase

class TvViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }

}