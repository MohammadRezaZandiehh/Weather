package com.example.weather.retrofirService

import androidx.lifecycle.LiveData
import com.example.weather.GetCountryName
import com.example.weather.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("find?lat=55.5&lon=37.5&cnt=10&appid=05e3e40f3e0c3d3220344dcbc089b43c")
    open fun getWeather(): Call<WeatherResponse>

    @GET("find?lat=55.5&lon=37.5&cnt=10&appid=05e3e40f3e0c3d3220344dcbc089b43c")
    fun getName(): Call<List<GetCountryName>>


    @GET("data/2.5/weather?")
//        fun getCurrentWeatherData(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): Call<WeatherResponse>
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") app_id: String
    ): Call<WeatherResponse>

}