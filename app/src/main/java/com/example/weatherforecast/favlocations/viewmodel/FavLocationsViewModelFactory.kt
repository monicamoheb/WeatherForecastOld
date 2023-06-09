package com.example.weatherforecast.favlocations.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecast.repo.RepoInterface

class FavLocationsViewModelFactory (private val _repo: RepoInterface):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(FavLocationsViewModel::class.java)){
            FavLocationsViewModel(_repo) as T
        }else{
            throw IllegalArgumentException("ViewModel class not found")
        }
    }
}