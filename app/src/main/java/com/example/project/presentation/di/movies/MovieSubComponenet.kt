package com.example.project.presentation.di.movies

import com.example.project.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponenet {
    fun inject(movieActivity: MovieActivity)
    //We must define a subcomponenet factory inside movie subcomponeneet.So that app componenet knows how to create instance of this artist component
    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponenet
    }
}