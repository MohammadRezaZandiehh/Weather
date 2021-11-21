package com.example.weather.KotlinModel


import com.google.gson.annotations.SerializedName

//data class Main(
////    @SerializedName("feels_like")
////    val feelsLike: Double,
////    @SerializedName("humidity")
////    val humidity: Int,
////    @SerializedName("pressure")
////    val pressure: Int,
////    @SerializedName("temp")
////    val temp: Double,
////    @SerializedName("temp_max")
////    val tempMax: Double,
////    @SerializedName("temp_min")
////    val tempMin: Double
//
//
//)


class Main {
    @SerializedName("temp")
    var temp: Float = 0.toFloat()

    @SerializedName("humidity")
    var humidity: Float = 0.toFloat()

    @SerializedName("pressure")
    var pressure: Float = 0.toFloat()

    @SerializedName("temp_min")
    var temp_min: Float = 0.toFloat()

    @SerializedName("temp_max")
    var temp_max: Float = 0.toFloat()
}