package com.example.flatrocktask.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.model.upcoming.UpcomingResult
import com.example.flatrocktask.ui.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpcomingViewModel:ViewModel() {
    private var _upComing = MutableLiveData<List<UpcomingResult>>()
    val upComing:LiveData<List<UpcomingResult>> get() = _upComing


    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.topRatedService.getUpcoming()
            }
           _upComing.postValue(data.body()?.results)
        }
    }
}
