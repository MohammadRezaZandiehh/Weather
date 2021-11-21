package com.example.weather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.weather.KotlinModel.Main
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {

//    val weatherLiveData = MutableLiveData<List>()
    val mainLiveData = MutableLiveData<Main>()
    val errorLiveData = MutableLiveData<String>()


    private val coroutineException = CoroutineExceptionHandler { coroutineContext, throwable ->
        errorLiveData.value = throwable.message
    }


    init {
        viewModelScope.launch(coroutineException) {
//            val weather = apiService.getWeather()
//            weatherLiveData.value = weather
//            val temp = apiService.getTemp()
//            mainLiveData.value = temp
        }
    }


}