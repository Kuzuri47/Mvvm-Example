package com.example.project.presentation.di.tvshows

import com.example.project.presentation.di.movies.MovieSubComponenet
import com.example.project.presentation.movie.MovieActivity
import com.example.project.presentation.tv.TvActivity
import dagger.Subcomponent

@TvScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvActivity: TvActivity)
    //We must define a subcomponenet factory inside movie subcomponeneet.So that app componenet knows how to create instance of this artist component
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }

}