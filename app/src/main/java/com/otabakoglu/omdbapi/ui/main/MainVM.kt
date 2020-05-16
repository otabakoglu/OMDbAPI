package com.otabakoglu.omdbapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otabakoglu.omdbapi.data.repository.OmdbRepository
import com.otabakoglu.omdbapi.data.repository.RepositoryImpl
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainVM @Inject constructor(private val repository: RepositoryImpl) : ViewModel(){

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status


    init {
        getFilm()
    }

    private fun getFilm(){
        viewModelScope.launch {

            try {
                val result = repository.getFilmByTitleAsync("blade").await()
                _status.value = result.toString()

                Timber.d(result.toString())
            }catch (exception: Exception){
                _status.value = exception.message
                Timber.d(exception)
            }

        }
    }
}