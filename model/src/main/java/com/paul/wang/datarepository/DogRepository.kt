package com.paul.wang.datarepository

import com.paul.wang.network.DogCEOService
import com.paul.wang.response.DogBreed
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class DogRepository @Inject constructor() {
    suspend fun getAllBreeds(): String? {
        return withContext(Dispatchers.IO) {
            val status = DogCEOService.getInstance().getAllBreeds().body()?.status
            Timber.tag("DogBreed").d("status is : $status, withContext() on : ${Thread.currentThread()}")
            status
        }
    }
}
