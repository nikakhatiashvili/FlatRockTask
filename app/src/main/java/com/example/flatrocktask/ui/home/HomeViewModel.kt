package com.example.flatrocktask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flatrocktask.ui.model.toprated.MovieResult
import com.example.flatrocktask.ui.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private var _topRatedMovies = MutableLiveData<List<MovieResult>>()
    val topRatedMovies:LiveData<List<MovieResult>> get() = _topRatedMovies



    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.topRatedService.getAllTopRatedMovies()
            }
            _topRatedMovies.postValue(data.body()?.results)
        }
    }


}