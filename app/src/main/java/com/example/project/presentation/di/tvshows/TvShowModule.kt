package com.example.project.presentation.di.tvshows

import com.example.project.domain.GetTvShowUseCase
import com.example.project.domain.UpdateTvShowUseCase
import com.example.project.presentation.tv.TvViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {
    @TvScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,
    updateTvShowUseCase: UpdateTvShowUseCase):TvViewModelFactory{
        return TvViewModelFactory(getTvShowUseCase,updateTvShowUseCase)
    }
}