package com.magorobot.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemsResponse>
)

data class SuperheroItemsResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String
)