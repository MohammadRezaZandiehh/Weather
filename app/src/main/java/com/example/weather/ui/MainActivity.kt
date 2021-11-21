package com.example.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.retrofirService.ApiService
import com.example.weather.R
import com.example.weather.WeatherResponse
import com.example.weather.adapter.WeatherAdapter
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

////                val responseList = response.body()!!.weather
////                val responseList = response.body()!!
////                binding.textViewCityName.text(responseList)
//
////                val mainAdapter = WeatherAdapter(responseList, this@MainActivity)
////                binding.rvMain.adapter = mainAdapter
////                binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var weatherData: TextView? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherLiveData.observe(this@MainActivity, androidx.lifecycle.Observer {
            it.enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    Log.d("dasdsa", "mamad")

                    val responseName = response.body()!!.getCountryName

                    val weatherAdapter: WeatherAdapter? =
                        responseName?.let { it1 -> WeatherAdapter(it1, this@MainActivity) }

                    binding.rvWeather.adapter = weatherAdapter
                    binding.rvWeather.layoutManager = LinearLayoutManager(this@MainActivity)

//                    binding.textView.text = responseName
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                }

            })
        })


//        weatherData = findViewById(R.id.textView)
//
//        findViewById<View>(R.id.button).setOnClickListener { getCurrentData() }
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BaseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val service = retrofit.create(ApiService::class.java)
//        service.getCurrentWeatherData(lat, lon, AppId).enqueue(object : Callback<WeatherResponse> {
//            override fun onResponse(
//                call: Call<WeatherResponse>,
//                response: Response<WeatherResponse>
//            ) {
//                Log.d("tagx", "")
//                var responseName = response.body()!!.getCountryName
//                val weatherAdapter = responseName?.let {
//                    WeatherAdapter(it, this@MainActivity)
//                }
//                val rvWeather: RecyclerView = findViewById(R.id.rvWeather)
//                rvWeather.adapter = weatherAdapter
//                rvWeather.layoutManager = LinearLayoutManager(this@MainActivity)
//            }
//
//            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
//                var a: Int = 2
//            }
//
//        })


    }

//    internal fun getCurrentData() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BaseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val service = retrofit.create(ApiService::class.java)
//        val call = service.getCurrentWeatherData(lat, lon, AppId)
//        call.enqueue(object : Callback<WeatherResponse> {
//            override fun onResponse(
//                call: Call<WeatherResponse>,
//                response: Response<WeatherResponse>
//            ) {

//                Log.d("tagx", "onCreate ")
//                if (response.code() == 200) {
//                    val weatherResponse = response.body()!!
//
//                    val stringBuilder = "Country: " +
//                            weatherResponse.sys!!.country +
//                            "\n" +
//                            "Temperature: " +
//                            weatherResponse.main!!.temp +
//                            "\n" +
//                            "Temperature(Min): " +
//                            weatherResponse.main!!.temp_min +
//                            "\n" +
//                            "Temperature(Max): " +
//                            weatherResponse.main!!.temp_max +
//                            "\n" +
//                            "Humidity: " +
//                            weatherResponse.main!!.humidity +
//                            "\n" +
//                            "Pressure: " +
//                            weatherResponse.main!!.pressure
//
//                    weatherData!!.text = stringBuilder
//                }
//            }

//            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
//                weatherData!!.text = t.message
//            }
//        })
}
