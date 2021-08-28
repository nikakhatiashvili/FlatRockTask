package com.example.flatrocktask.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularViewModel :ViewModel(){

    private var _mostPopular = MutableLiveData<List<PopularResult>>()
    val mostPopular:LiveData<List<PopularResult>> get() = _mostPopular



    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.topRatedService.getPopular()
            }
            _mostPopular.postValue(data.body()?.results)
        }
    }





}