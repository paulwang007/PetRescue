package com.paul.wang.view.activity.breedlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.paul.wang.core_logic.DogBreedViewModel
import com.paul.wang.view.R
import com.paul.wang.view.adapter.DogBreedAdapter
import com.paul.wang.view.databinding.ActivityDogBreedBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DogBreedActivity : AppCompatActivity() {
    private val dogBreedViewModel: DogBreedViewModel by viewModels()
    private val dogBreedAdapter by lazy { DogBreedAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDogBreedBinding>(
            this,
            R.layout.activity_dog_breed
        )
        binding.lifecycleOwner = this
        binding.viewmodel = dogBreedViewModel
        binding.dogBreedRecyclerView.adapter = dogBreedAdapter


        dogBreedViewModel.dogBreed.observe(this) {
//            dogBreedAdapter.dogBreedList = this
            Timber.tag("DogBreed")
                .d("Observing dogBreed = $it on thread: ${Thread.currentThread()} ")
        }
    }

    override fun onResume() {
        super.onResume()

        dogBreedViewModel.getAllBreeds()
    }
}
