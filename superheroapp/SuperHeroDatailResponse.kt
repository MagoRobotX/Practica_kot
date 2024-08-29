package com.magorobot.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDatailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatusResponse,
    @SerializedName("image") val image:SuperoheroImageDatailResponse
)

data class PowerStatusResponse(
    @SerializedName("name") val name: String,
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)
data class SuperoheroImageDatailResponse(@SerializedName("url") val url:String)
