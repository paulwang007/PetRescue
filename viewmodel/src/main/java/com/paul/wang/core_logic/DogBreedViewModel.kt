package com.paul.wang.core_logic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paul.wang.datarepository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedViewModel @Inject constructor(private val dogRepository: DogRepository) :
    ViewModel() {

    val dogBreed = MutableLiveData<String>()

    fun getAllBreeds() {
        viewModelScope.launch {
            dogBreed.postValue(dogRepository.getAllBreeds())
        }
    }
}
