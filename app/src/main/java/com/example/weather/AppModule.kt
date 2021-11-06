package com.example.weather

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
    ):ApiService {
        return Retrofit.Builder()
//            .baseUrl("http://expertdevelopers.ir/api/v1/")
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}