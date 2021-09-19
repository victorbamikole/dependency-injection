package com.example.dependencyinjection.main

import com.example.dependencyinjection.model.UserItem
import com.example.dependencyinjection.network.RetroService
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: RetroService) {
    suspend fun getPosts(): List<UserItem> {
        return api.getDataFromApi()
    }
}