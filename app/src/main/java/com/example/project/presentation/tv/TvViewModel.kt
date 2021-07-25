package com.example.project.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.project.domain.GetTvShowUseCase
import com.example.project.domain.UpdateTvShowUseCase

class TvViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
):ViewModel() {
    fun getTv() =  liveData {
        val tvList = getTvShowUseCase.execute()
        emit(tvList)
    }
    fun updateTvShows() =  liveData {
        val tvList = updateTvShowUseCase.execute()
        emit(tvList)
    }
}