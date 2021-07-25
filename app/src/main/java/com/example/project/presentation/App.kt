package com.example.project.presentation

import android.app.Application
import com.example.project.BuildConfig
import com.example.project.presentation.di.core.*
import com.example.project.presentation.di.movies.MovieSubComponenet
import com.example.project.presentation.di.tvshows.TvShowSubComponent

class App :Application(),Injector {
    //Delcare refrence variable for app component interface.
    private lateinit var appComponenet: TMDBComponent
    override fun onCreate() {
        super.onCreate()
        appComponenet = DaggerTMDBComponent.builder()
            .applicatioModule(ApplicatioModule((applicationContext)))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMoviesSubComponenet(): MovieSubComponenet {
        return appComponenet.moviesSubComponenet().create()
    }

    override fun createTvShowSubComponenet(): TvShowSubComponent {
        return appComponenet.tvShowSubComponent().create()
    }
    //We need to add this app class to the manifest.
}