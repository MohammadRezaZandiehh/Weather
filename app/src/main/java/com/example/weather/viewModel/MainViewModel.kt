package com.example.weather.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.weather.WeatherResponse
import com.example.weather.allModels.modelJava.KotlinModel.Main
import com.example.weather.retrofirService.ApiService
import com.example.weather.utils.Constants.AppId
import com.example.weather.utils.Constants.lat
import com.example.weather.utils.Constants.lon
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val weatherLiveData = MutableLiveData<Call<WeatherResponse>>()
    val errorLiveData = MutableLiveData<String>()


    private val coroutineException = CoroutineExceptionHandler { coroutineContext, throwable ->
        errorLiveData.value = throwable.message
    }

    init {
        getWeatherFromApiService()
    }

    fun getWeatherFromApiService() {
        viewModelScope.launch(coroutineException) {

            val weather = apiService.getCurrentWeatherData(
                lat,
                lon,
                AppId
            )
            weatherLiveData.value = weather
        }
    }
}