package com.example.project.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicatioModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}