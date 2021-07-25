package com.example.project.presentation.di.core

import com.example.project.presentation.di.movies.MovieSubComponenet
import com.example.project.presentation.di.tvshows.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicatioModule::class,
    NetModule::class,
DatabaseModule::class,
CachedDataModule::class,
LocalDataSourceModule::class,
RemoteDataModule::class,
UseCaseModule::class,
RepositoryModule::class
])
interface TMDBComponent {
//Define functions to get subcomponenet factories
    fun moviesSubComponenet():MovieSubComponenet.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    //Now we need to create a class because we have subcomponents. So to get subcomponenet instances we need it.


}