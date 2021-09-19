package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.UserItem
import retrofit2.Response
import retrofit2.http.GET

interface RetroService {

    @GET("users")
    //This function queries our Api and returns the data class
//    suspend fun getDataFromApi(@Query("q") query: String): RecyclerListData
    suspend fun getDataFromApi(): List<UserItem>
}