package com.example.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

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
                        responseName?.let { responseName ->
                            WeatherAdapter(
                                responseName,
                                this@MainActivity
                            )
                        }

                    binding.rvWeather.adapter = weatherAdapter
                    binding.rvWeather.layoutManager = LinearLayoutManager(this@MainActivity)

                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    viewModel.errorLiveData.observe(this@MainActivity, androidx.lifecycle.Observer {
                        Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
                    })
                }
            })
        })
    }
}
