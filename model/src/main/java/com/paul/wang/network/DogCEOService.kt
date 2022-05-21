package com.paul.wang.network

import com.paul.wang.response.DogBreedResponse
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton

interface DogCEOService {
    @GET("api/breeds/list/all")
    suspend fun getAllBreeds(): Response<DogBreedResponse>

    companion object {
        private var retrofitDogCEOService: DogCEOService? = null
        fun getInstance(): DogCEOService {
            if (retrofitDogCEOService == null) {
                val retrofit = Retrofit.Builder().baseUrl("https://dog.ceo/")
                    .addConverterFactory(GsonConverterFactory.create()).build()

                retrofitDogCEOService = retrofit.create(DogCEOService::class.java)
            }
            return retrofitDogCEOService!!
        }
    }
}
