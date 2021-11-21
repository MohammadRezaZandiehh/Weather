package com.example.weather.module

import com.example.weather.retrofirService.ApiService
import com.example.weather.utils.Constants.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


//    @Provides
//    fun provideBaseUrl() = Constants.BASE_URL


    @Singleton
    @Provides
    fun provideAnalyticsService (
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}