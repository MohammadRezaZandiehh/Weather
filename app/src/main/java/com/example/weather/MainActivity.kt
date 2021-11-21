package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.KotlinModel.KotlinWeather
import com.example.weather.adapter.WeatherAdapter
import com.example.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private val viewModel: MainViewModel by viewModels()
//    lateinit var binding: ActivityMainBinding
//
//    companion object {
//        var BaseUrl = "https://api.openweathermap.org/data/2.5/"
//        var AppId = "05e3e40f3e0c3d3220344dcbc089b43c"
//        var lat = "35"
//        var lon = "139"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        viewModel.mainLiveData.observe(this@MainActivity, Observer {
//            Log.d("MainActivity1", "onCreate: ")
////            it.temp.
//        })
//
//        viewModel.errorLiveData.observe(this, Observer {
//            println(it)
//        })
//
//
//        /////////////////////////////////
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BaseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(ApiService::class.java)
//        val call = service.getCurrentWeatherData(lat, lon, AppId)
//
////        internal fun getCurrentData() {
////            val retrofit = Retrofit.Builder()
////                .baseUrl(BaseUrl)
////                .addConverterFactory(GsonConverterFactory.create())
////                .build()
////            val service = retrofit.create(ApiService::class.java)
////            val call = service.getCurrentWeatherData(lat, lon, AppId)
//
////                Log.d("MainActivity", "onCreate: ")
////                val responseList = response.body()!!.weather
////                val responseList = response.body()!!
////                binding.textViewCityName.text(responseList)
//
////                val mainAdapter = WeatherAdapter(responseList, this@MainActivity)
////                binding.rvMain.adapter = mainAdapter
////                binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
class MainActivity : AppCompatActivity() {

    private var weatherData: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherData = findViewById(R.id.textView)

        findViewById<View>(R.id.button).setOnClickListener { getCurrentData() }


    }

    internal fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, AppId)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = "Country: " +
                            weatherResponse.sys!!.country +
                            "\n" +
                            "Temperature: " +
                            weatherResponse.main!!.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherResponse.main!!.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            weatherResponse.main!!.temp_max +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main!!.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main!!.pressure

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }
        })
    }

    companion object {

        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2e65127e909e178d0af311a81f39948c"
        var lat = "35"
        var lon = "139"
    }
}

private fun test (){
    //mamadererernksw
}