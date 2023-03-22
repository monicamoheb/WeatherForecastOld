package com.example.weatherforecast.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.ApiState
import com.example.weatherforecast.repo.RepoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val _repo: RepoInterface) : ViewModel() {

    private var _stateFlow=MutableStateFlow<ApiState>( ApiState.Loading)
    val stateFlow:StateFlow<ApiState> = _stateFlow

    init {
        getCurrentWeatherDB()
    }

    fun getCurrentWeatherOnline(lat: String, lon: String) =
        viewModelScope.launch(Dispatchers.IO) {
            _repo.getCurrentWeatherOnline(lat, lon)
        }

    private fun getCurrentWeatherDB() =
        viewModelScope.launch(Dispatchers.IO) {
            _repo.getCurrentWeatherDB().catch { _stateFlow.value = ApiState.Failure(it)}
                .collect{data->
                    _stateFlow.value=ApiState.Success(data)}
        }
    //check network
    // if yes -> location -> lat,lon -> online + a5ezn f db
    //if no retrive from db
}
