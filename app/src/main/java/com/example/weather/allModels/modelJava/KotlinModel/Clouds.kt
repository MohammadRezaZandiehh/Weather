package com.example.weather.allModels.modelJava.KotlinModel


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int
)