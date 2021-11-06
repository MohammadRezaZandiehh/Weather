package com.example.weather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.weather.model.Weather
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val studentLiveData = MutableLiveData<List<Weather>>()
    val errorLiveData = MutableLiveData<String>()


    private val coroutineException = CoroutineExceptionHandler { coroutineContext, throwable ->
        errorLiveData.value = throwable.message
    }


    init {
        viewModelScope.launch (coroutineException){
            val weathers = apiService.getStudent()
            studentLiveData.value = weathers
        }
    }


}