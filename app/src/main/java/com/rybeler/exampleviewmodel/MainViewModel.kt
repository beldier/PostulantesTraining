package com.rybeler.exampleviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rybeler.exampleviewmodel.data.network.ApiClient
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()  {

    private val _contador = MutableLiveData<Int>(0)
    val contador:LiveData<Int> = _contador


    fun updateContador(increment:Int){
        _contador.value = (_contador.value?:0) + increment
    }
}