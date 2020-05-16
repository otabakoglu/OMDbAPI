package com.otabakoglu.omdbapi.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otabakoglu.omdbapi.data.model.FilmProperty
import javax.inject.Inject

class DetailVM @Inject constructor(): ViewModel() {

    private val _selectedProperty = MutableLiveData<FilmProperty>()

    val selectedProperty: LiveData<FilmProperty>
        get() = _selectedProperty

    fun setProperty(property: FilmProperty) {
        _selectedProperty.value = property
    }
}
