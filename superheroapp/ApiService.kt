package com.magorobot.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/api/38b97def13400f62326aeb53dcb24a8b/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>


}