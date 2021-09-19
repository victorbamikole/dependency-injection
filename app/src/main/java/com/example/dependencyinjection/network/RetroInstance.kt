package com.example.dependencyinjection.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroInstance {

    //The retro instance class for the base url is created
    companion object {
        const val BaseURL = "https://jsonplaceholder.typicode.com/"

        private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private val okHttp = OkHttpClient.Builder().addInterceptor(logger)

        fun getRetroInstance(): RetroService {
            return Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build().create(RetroService::class.java)

        }

    }
}