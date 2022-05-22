package com.paul.wang.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.paul.wang.view.R
import com.paul.wang.view.databinding.RecyclerItemDogBreedBinding
import com.paul.wang.viewmodel.DogBreedList

class DogBreedAdapter : RecyclerView.Adapter<DogBreedViewHolder>() {
    var dogBreedList : DogBreedList? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedViewHolder {
        val binding = DataBindingUtil.inflate<RecyclerItemDogBreedBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item_dog_breed,
            parent,
            false
        )

        return DogBreedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogBreedViewHolder, position: Int) {
        // TODO
        holder.breed.text = "terrier"
    }

    override fun getItemCount(): Int {
        // TODO
        return 100
    }
}

class DogBreedViewHolder(binding: RecyclerItemDogBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val breed = binding.dogBreedText
    val subBreed = binding.dogSubBreedText
}
