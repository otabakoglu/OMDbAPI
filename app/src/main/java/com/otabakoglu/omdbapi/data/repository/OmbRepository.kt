package com.otabakoglu.omdbapi.data.repository

import com.otabakoglu.omdbapi.data.model.FilmProperty
import kotlinx.coroutines.Deferred

interface OmdbRepository {
    fun getFilmByTitleAsync(title: String): Deferred<FilmProperty>
}