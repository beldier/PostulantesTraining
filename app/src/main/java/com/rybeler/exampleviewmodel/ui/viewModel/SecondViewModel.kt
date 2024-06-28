package com.rybeler.exampleviewmodel.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rybeler.exampleviewmodel.data.models.Character
import com.rybeler.exampleviewmodel.data.network.ApiClient
import kotlinx.coroutines.launch
import java.time.ZoneOffset


class SecondViewModel : ViewModel() {

    private val _caracteres = MutableLiveData<List<Character>>()
    val caracteres: LiveData<List<Character>> = _caracteres


    init {
        viewModelScope.launch {
            _caracteres.value = getFullListOfCharacters()

        }
    }

    private suspend fun getFullListOfCharacters(offset: Int = 0, limit: Int = 100) =
        ApiClient.charactersService.getCharacters(limit = limit, offset = offset).data.results
}