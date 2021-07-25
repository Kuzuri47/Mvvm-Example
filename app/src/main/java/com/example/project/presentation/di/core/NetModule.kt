package com.example.project.presentation.di.core

import com.example.project.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//This is network module.
@Module
class NetModule(private val baseUrl:String) {
    //To provide a retrofit instance we need a base url.
    //To keep single retrofit instance during the entire operational time of an app
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    @Singleton
    @Provides
    fun provideTMDBService(retrofit:Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}