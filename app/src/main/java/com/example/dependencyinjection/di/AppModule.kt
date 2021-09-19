package com.example.dependencyinjection.di

import com.example.dependencyinjection.main.MainRepository
import com.example.dependencyinjection.network.RetroInstance
import com.example.dependencyinjection.network.RetroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun getRetroInstance(): RetroService = RetroInstance.getRetroInstance()


    @Provides
    @Singleton
    fun provideMainRepository(api: RetroService): MainRepository = MainRepository(api)

}