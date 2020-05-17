package com.otabakoglu.omdbapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otabakoglu.omdbapi.data.model.FilmProperty
import com.otabakoglu.omdbapi.data.repository.RepositoryImpl
import com.otabakoglu.omdbapi.data.source.remote.OmdbApiStatus
import kotlinx.coroutines.*
import javax.inject.Inject

class MainVM @Inject constructor(private val repository: RepositoryImpl) : ViewModel() {

    private val _status = MutableLiveData<OmdbApiStatus>()
    val status: LiveData<OmdbApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<FilmProperty>>()
    val properties: LiveData<List<FilmProperty>>
        get() = _properties

    fun clearList() {
        _properties.value = emptyList()
        _status.value = OmdbApiStatus.DONE
    }

    fun getFilm(title: String) {

        viewModelScope.launch {
            try {

                _status.value = OmdbApiStatus.LOADING

                val result = repository.getFilmByTitleAsync(title).await()

                if (result.isResponse()) {
                    val films: List<FilmProperty> = listOf(result,result,result,result,result,result,result,result)
                    _properties.value = films
                    _status.value = OmdbApiStatus.DONE
                } else {
                    _properties.value = emptyList()
                    _status.value = OmdbApiStatus.FILM_NOT_FOUND
                }

            } catch (exception: Exception) {
                _properties.value = emptyList()
                _status.value = OmdbApiStatus.ERROR
                println(exception)
            }


        }

    }

}