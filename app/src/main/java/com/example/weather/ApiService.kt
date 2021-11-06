package com.example.weather

import com.example.weather.model.Weather
import retrofit2.http.GET

interface ApiService {

//    @GET("experts/student")
    @GET("weather?q=tehran&appid=05e3e40f3e0c3d3220344dcbc089b43c&lang=fa")
    suspend fun getStudent(): List<Weather>
}